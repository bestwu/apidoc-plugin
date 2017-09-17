package cn.bestwu.apidoc

import java.io.*
import java.nio.charset.Charset
import java.util.*
import java.util.regex.Pattern

enum class Status {
    INIT,
    IN_FINISHED_VALUE,
    IN_OBJECT,
    IN_ARRAY,
    PASSED_PAIR_KEY,
    PAIR_VALUE,
    IN_ERROR,
    EOF
}

class Token(val tokenType: Type, val value: Any?) {
    override fun toString(): String {
        val v = if (value != null) {
            " ($value)"
        } else {
            ""
        }
        return tokenType.toString() + v
    }
}

enum class Type {
    VALUE,
    LEFT_BRACE,
    RIGHT_BRACE,
    LEFT_BRACKET,
    RIGHT_BRACKET,
    COMMA,
    COLON,
    EOF
}

fun Appendable.indent(level: Int) {
    for (i in 1..level) {
        append("  ")
    }
}

class Lexer(reader: Reader) {
    constructor(stream: InputStream, charset: Charset = Charsets.UTF_8) : this(stream.reader(charset))

    val EOF = Token(Type.EOF, null)
    var index = 0

    val NUMERIC = Pattern.compile("[-]?[0-9]+")
    val DOUBLE = Pattern.compile(NUMERIC.toString() + "((\\.[0-9]+)?([eE][-+]?[0-9]+)?)")

    fun isSpace(c: Char): Boolean {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t'
    }

    private val reader = reader.buffered()
    private var next: Char? = null

    private fun nextChar(): Char {
        if (isDone()) throw IllegalStateException("Cannot get next char: EOF reached")
        val c = next!!
        next = null
        return c
    }

    private fun peekChar(): Char {
        if (isDone()) throw IllegalStateException("Cannot peek next char: EOF reached")
        return next!!
    }

    private fun isDone(): Boolean {
        if (next != null) {
            return false
        }
        index++
        val read = reader.read()
        if (read == -1) return true
        next = read.toChar()
        return false
    }

    val BOOLEAN_LETTERS = "falsetrue".toSet()
    private fun isBooleanLetter(c: Char): Boolean {
        return BOOLEAN_LETTERS.contains(Character.toLowerCase(c))
    }

    val NULL_LETTERS = "null".toSet()

    fun isValueLetter(c: Char): Boolean {
        return c == '-' || c == '+' || c == '.' || c.isDigit() || isBooleanLetter(c)
                || c in NULL_LETTERS
    }

    fun nextToken(): Token {

        if (isDone()) {
            return EOF
        }

        val tokenType: Type
        var c = nextChar()
        val currentValue = StringBuilder()
        var jsonValue: Any? = null

        while (!isDone() && isSpace(c)) {
            c = nextChar()
        }

        if ('"' == c) {
            tokenType = Type.VALUE
            loop@
            do {
                if (isDone()) {
                    throw RuntimeException("Unterminated string")
                }

                c = nextChar()
                when (c) {
                    '\\' -> {
                        if (isDone()) {
                            throw RuntimeException("Unterminated string")
                        }

                        c = nextChar()
                        when (c) {
                            '\\' -> currentValue.append("\\")
                            '/' -> currentValue.append("/")
                            'b' -> currentValue.append("\b")
                            'f' -> currentValue.append("\u000c")
                            'n' -> currentValue.append("\n")
                            'r' -> currentValue.append("\r")
                            't' -> currentValue.append("\t")
                            'u' -> {
                                val unicodeChar = StringBuilder(4)
                                        .append(nextChar())
                                        .append(nextChar())
                                        .append(nextChar())
                                        .append(nextChar())

                                val intValue = java.lang.Integer.parseInt(unicodeChar.toString(), 16)
                                currentValue.append(intValue.toChar())
                            }
                            else -> currentValue.append(c)
                        }
                    }
                    '"' -> break@loop
                    else -> currentValue.append(c)
                }
            } while (true)

            jsonValue = currentValue.toString()
        } else if ('{' == c) {
            tokenType = Type.LEFT_BRACE
        } else if ('}' == c) {
            tokenType = Type.RIGHT_BRACE
        } else if ('[' == c) {
            tokenType = Type.LEFT_BRACKET
        } else if (']' == c) {
            tokenType = Type.RIGHT_BRACKET
        } else if (':' == c) {
            tokenType = Type.COLON
        } else if (',' == c) {
            tokenType = Type.COMMA
        } else if (!isDone()) {
            while (isValueLetter(c)) {
                currentValue.append(c)
                if (!isValueLetter(peekChar())) {
                    break
                } else {
                    c = nextChar()
                }
            }
            val v = currentValue.toString()
            if (NUMERIC.matcher(v).matches()) {
                try {
                    jsonValue = java.lang.Integer.parseInt(v)
                } catch (e: NumberFormatException) {
                    try {
                        jsonValue = java.lang.Long.parseLong(v)
                    } catch (e: NumberFormatException) {
                        jsonValue = java.math.BigInteger(v)
                    }
                }
            } else if (DOUBLE.matcher(v).matches()) {
                jsonValue = java.lang.Double.parseDouble(v)
            } else if ("true".equals(v.toLowerCase())) {
                jsonValue = true
            } else if ("false".equals(v.toLowerCase())) {
                jsonValue = false
            } else if (v == "null") {
                jsonValue = null
            } else {
                throw RuntimeException("Unexpected character at position $index"
                        + ": '$c (${c.toInt()})'")
            }

            tokenType = Type.VALUE
        } else {
            tokenType = Type.EOF
        }

        return Token(tokenType, jsonValue)
    }
}

class World(var status: Status) {
    private val statusStack = LinkedList<Status>()
    private val valueStack = LinkedList<Any>()
    var result: Any? = null
    var parent = mutableMapOf<String, Any?>()

    fun pushAndSet(status: Status, value: Any): World {
        pushStatus(status)
        pushValue(value)
        this.status = status
        return this
    }

    fun pushStatus(status: Status): World {
        statusStack.addFirst(status)
        return this
    }

    fun pushValue(value: Any): World {
        valueStack.addFirst(value)
        return this
    }

    fun popValue(): Any {
        return valueStack.removeFirst()
    }

    fun popStatus(): Status {
        return statusStack.removeFirst()
    }

    @Suppress("UNCHECKED_CAST")
    fun getFirstObject(): MutableMap<String, Any?> {
        return valueStack.first as MutableMap<String, Any?>
    }

    @Suppress("UNCHECKED_CAST")
    fun getFirstArray(): MutableList<Any?> {
        return valueStack.first as MutableList<Any?>
    }

    fun peekStatus(): Status {
        return statusStack.get(0)
    }

    fun hasValues(): Boolean {
        return valueStack.size > 1
    }
}

private data class TokenStatus(val status: Status, val tokenType: Type)

class StateMachine {
    private val map = hashMapOf<TokenStatus, (world: World, token: Token) -> World>()

    fun put(status: Status, tokenType: Type, processor: (world: World, token: Token) -> World) {
        map.put(TokenStatus(status, tokenType), processor)
    }

    fun next(world: World, token: Token): World {
        val pair = TokenStatus(world.status, token.tokenType)
        val processor = map[pair]

//        println("${status} ${token.tokenType} -> ${world.status}")
        return if (processor != null) {
            processor(world, token)
        } else {
            val message = "No state found: ${world.status} $token"
            throw RuntimeException(message)
        }
    }
}

/**
 * Main entry for Klaxon's parser.
 */
class Parser {
    val verbose = false

    fun log(s: String) {
        if (verbose) {
            println("[Parser2] $s")
        }
    }

    fun parse(rawValue: StringBuilder): Any? =
            StringReader(rawValue.toString()).use {
                parse(it)
            }

    fun parse(fileName: String): Any? =
            FileInputStream(File(fileName)).use {
                parse(it)
            }

    fun parse(inputStream: InputStream, charset: Charset = Charsets.UTF_8): Any? {
        return parse(inputStream.reader(charset))
    }

    fun parse(reader: Reader): Any? {

        val sm = StateMachine()

        sm.put(Status.INIT, Type.VALUE, { world: World, token: Token ->
            world.pushAndSet(Status.IN_FINISHED_VALUE, token.value!!)
        })
        sm.put(Status.INIT, Type.LEFT_BRACE, { world: World, _: Token ->
            world.pushAndSet(Status.IN_OBJECT, mutableMapOf<String, Any?>())
        })
        sm.put(Status.INIT, Type.LEFT_BRACKET, { world: World, _: Token ->
            world.pushAndSet(Status.IN_ARRAY, mutableListOf<Any>())
        })
        // else error

        sm.put(Status.IN_FINISHED_VALUE, Type.EOF, { world: World, _: Token ->
            world.result = world.popValue()
            world
        })
        // else error


        sm.put(Status.IN_OBJECT, Type.COMMA, { world: World, _: Token ->
            world
        })
        sm.put(Status.IN_OBJECT, Type.VALUE, { world: World, token: Token ->
            world.pushAndSet(Status.PASSED_PAIR_KEY, token.value!!)
        })
        sm.put(Status.IN_OBJECT, Type.RIGHT_BRACE, { world: World, _: Token ->
            if (world.hasValues()) {
                world.popStatus()
                world.popValue()
                world.status = world.peekStatus()
            } else {
                world.status = Status.IN_FINISHED_VALUE
            }
            world
        })


        sm.put(Status.PASSED_PAIR_KEY, Type.COLON, { world: World, _: Token ->
            world
        })
        sm.put(Status.PASSED_PAIR_KEY, Type.VALUE, { world: World, token: Token ->
            world.popStatus()
            val key = world.popValue() as String
            world.parent = world.getFirstObject()
            world.parent.put(key, token.value)
            world.status = world.peekStatus()
            world
        })
        sm.put(Status.PASSED_PAIR_KEY, Type.LEFT_BRACKET, { world: World, _: Token ->
            world.popStatus()
            val key = world.popValue() as String
            world.parent = world.getFirstObject()
            val newArray = mutableListOf<Any>()
            world.parent.put(key, newArray)
            world.pushAndSet(Status.IN_ARRAY, newArray)
        })
        sm.put(Status.PASSED_PAIR_KEY, Type.LEFT_BRACE, { world: World, _: Token ->
            world.popStatus()
            val key = world.popValue() as String
            world.parent = world.getFirstObject()
            val newObject = mutableMapOf<String, Any?>()
            world.parent.put(key, newObject)
            world.pushAndSet(Status.IN_OBJECT, newObject)
        })
        // else error

        sm.put(Status.IN_ARRAY, Type.COMMA, { world: World, _: Token ->
            world
        })
        sm.put(Status.IN_ARRAY, Type.VALUE, { world: World, token: Token ->
            val value = world.getFirstArray()
            value.add(token.value)
            world
        })
        sm.put(Status.IN_ARRAY, Type.RIGHT_BRACKET, { world: World, _: Token ->
            if (world.hasValues()) {
                world.popStatus()
                world.popValue()
                world.status = world.peekStatus()
            } else {
                world.status = Status.IN_FINISHED_VALUE
            }
            world
        })
        sm.put(Status.IN_ARRAY, Type.LEFT_BRACE, { world: World, _: Token ->
            val value = world.getFirstArray()
            val newObject = mutableMapOf<String, Any?>()
            value.add(newObject)
            world.pushAndSet(Status.IN_OBJECT, newObject)
        })
        sm.put(Status.IN_ARRAY, Type.LEFT_BRACKET, { world: World, _: Token ->
            val value = world.getFirstArray()
            val newArray = mutableListOf<Any>()
            value.add(newArray)
            world.pushAndSet(Status.IN_ARRAY, newArray)
        })
        // else error

        val lexer = Lexer(reader)

        var world = World(Status.INIT)
        do {
            val token = lexer.nextToken()
            log("Token: $token")
            world = sm.next(world, token)
        } while (token.tokenType != Type.EOF)

        return world.result
    }
}