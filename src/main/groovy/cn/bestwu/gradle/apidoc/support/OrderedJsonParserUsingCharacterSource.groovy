package cn.bestwu.gradle.apidoc.support

import groovy.json.JsonException
import groovy.json.internal.*

class OrderedJsonParserUsingCharacterSource extends BaseJsonParser {

    private CharacterSource characterSource
    protected static final char[] NULL = Chr.chars("null")
    protected static final char[] TRUE = Chr.chars("true")
    protected static char[] FALSE = Chr.chars("false")
    private CharBuf builder = CharBuf.create(20)

    OrderedJsonParserUsingCharacterSource() {
    }

    protected String exceptionDetails(String message) {
        return this.characterSource.errorDetails(message)
    }

    protected final Object decodeJsonObject() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>()

        try {
            CharacterSource ex = this.characterSource
            if (ex.currentChar() == 123) {
                ex.nextChar()
            }

            while (ex.hasChar()) {
                ex.skipWhiteSpace()
                if (ex.currentChar() == 34) {
                    String ch = this.decodeString()
                    if (internKeys) {
                        String value = internedKeysCache.get(ch)
                        if (value == null) {
                            ch = ch.intern()
                            internedKeysCache.put(ch, ch)
                        } else {
                            ch = value
                        }
                    }

                    ex.skipWhiteSpace()
                    if (ex.currentChar() != 58) {
                        this.complain("expecting current character to be : but was " + this
                                .charDescription(ex.currentChar()) + "\n")
                    }

                    ex.nextChar()
                    ex.skipWhiteSpace()
                    Object value1 = this.decodeValue()
                    ex.skipWhiteSpace()
                    map.put(ch, value1)
                }

                int ch1 = ex.currentChar()
                if (ch1 == 125) {
                    ex.nextChar()
                    break
                }

                if (ch1 == 44) {
                    ex.nextChar()
                } else {
                    this.complain(
                            "expecting \'}\' or \',\' but got current char " + this.charDescription(ch1))
                }
            }

            return map
        } catch (Exception var5) {
            throw new JsonException(this.exceptionDetails("Unable to parse JSON object"), var5)
        }
    }

    protected final void complain(String complaint) {
        throw new JsonException(this.exceptionDetails(complaint))
    }

    private Object decodeValue() {
        CharacterSource characterSource = this.characterSource
        Object value
        characterSource.skipWhiteSpace()
        switch (characterSource.currentChar()) {
            case 34:
                value = this.decodeString()
                break
            case 45:
                value = this.decodeNumber(true)
                break
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                value = this.decodeNumber(false)
                break
            case 91:
                value = this.decodeJsonArray()
                break
            case 102:
                value = this.decodeFalse()
                break
            case 110:
                value = this.decodeNull()
                break
            case 116:
                value = this.decodeTrue()
                break
            case 123:
                value = this.decodeJsonObject()
                break
            default:
                throw new JsonException(this.exceptionDetails(
                        "Unable to determine the current character, it is not a string, number, array, or object"))
        }

        return value
    }

    private Object decodeNumber(boolean negative) {
        char[] chars = this.characterSource.readNumber()
        Object value = null
        if (CharScanner.hasDecimalChar(chars, negative)) {
            value = CharScanner.parseBigDecimal(chars)
        } else if (CharScanner.isInteger(chars)) {
            value = CharScanner.parseInt(chars)
        } else if (CharScanner.isLong(chars)) {
            value = CharScanner.parseLong(chars)
        }

        return value
    }

    protected final Object decodeNull() {
        if (!this.characterSource.consumeIfMatch(NULL)) {
            throw new JsonException(this.exceptionDetails("null not parse properly"))
        } else {
            return null
        }
    }

    protected final boolean decodeTrue() {
        if (this.characterSource.consumeIfMatch(TRUE)) {
            return true
        } else {
            throw new JsonException(this.exceptionDetails("true not parsed properly"))
        }
    }

    protected final boolean decodeFalse() {
        if (this.characterSource.consumeIfMatch(FALSE)) {
            return false
        } else {
            throw new JsonException(this.exceptionDetails("false not parsed properly"))
        }
    }

    private String decodeString() {
        CharacterSource characterSource = this.characterSource
        characterSource.nextChar()
        char[] chars = characterSource.findNextChar(34, 92)
        String value
        if (characterSource.hadEscape()) {
            value = this.builder.decodeJsonString(chars).toString()
            this.builder.recycle()
        } else {
            value = new String(chars)
        }

        return value
    }

    protected final List decodeJsonArray() {
        ArrayList<Object> list
        boolean foundEnd = false

        try {
            CharacterSource ex = this.characterSource
            if (this.characterSource.currentChar() == 91) {
                ex.nextChar()
            }

            ex.skipWhiteSpace()
            if (this.characterSource.currentChar() == 93) {
                ex.nextChar()
                return new ArrayList()
            }

            list = new ArrayList<>()

            ex.skipWhiteSpace()
            Object arrayItem = this.decodeValue()
            list.add(arrayItem)
            ex.skipWhiteSpace()
            int c = ex.currentChar()
            if (c == 44) {
                ex.nextChar()
            } else if (c == 93) {
                foundEnd = true
                ex.nextChar()
            } else {
                String charString = this.charDescription(c)
                this.complain(String.format(
                        "expecting a \',\' or a \']\',  but got \nthe current character of  %s  on array index of %s \n",
                        charString, list.size()))
            }

            while (ex.hasChar()) {
                ex.skipWhiteSpace()
                arrayItem = this.decodeValue()
                list.add(arrayItem)
                ex.skipWhiteSpace()
                c = ex.currentChar()
                if (c == 44) {
                    ex.nextChar()
                } else {
                    if (c == 93) {
                        foundEnd = true
                        ex.nextChar()
                        break
                    }

                    String charString = this.charDescription(c)
                    this.complain(String.format(
                            "expecting a \',\' or a \']\',  but got \nthe current character of  %s  on array index of %s \n",
                            charString, list.size()))
                }
            }
        } catch (Exception var7) {
            throw new JsonException(this.exceptionDetails("Unexpected issue"), var7)
        }

        if (!foundEnd) {
            throw new JsonException(this.exceptionDetails("Could not find end of JSON array"))
        } else {
            return list
        }
    }

    Object parse(Reader reader) {
        this.characterSource = new ReaderCharacterSource(reader)
        return this.decodeValue()
    }

    Object parse(char[] chars) {
        return this.parse(new StringReader(new String(chars)))
    }
}
