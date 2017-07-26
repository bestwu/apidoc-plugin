package cn.bestwu.gradle.apidoc.support

/**
 *
 * @author Peter Wu
 * @since
 */
class UnescapeUnicodeUtil {

    /**
     *
     * @param str 待处理字符串
     * @return unescapeUnicode
     */
    static String unescapeUnicode(String str) {
        StringWriter out = new StringWriter()
        if (str != null) {
            int sz = str.length()
            StringBuilder unicode = new StringBuilder(4)
            boolean hadSlash = false
            boolean inUnicode = false

            for (int i = 0; i < sz; ++i) {
                char ch = str.charAt(i)
                if (inUnicode) {
                    unicode.append(ch)
                    if (unicode.length() == 4) {
                        try {
                            int value = Integer.parseInt(unicode.toString(), 16)
                            out.write((char) value)
                            unicode.setLength(0)
                            inUnicode = false
                            hadSlash = false
                        } catch (NumberFormatException var9) {
                            throw new RuntimeException("Unable to parse unicode value: " + unicode, var9)
                        }
                    }
                } else if (hadSlash) {
                    hadSlash = false
                    switch (ch) {
                        case 'u':
                            inUnicode = true
                            break
                        default:
                            out.write("\\" + ch)
                    }
                } else if (ch == '\\') {
                    hadSlash = true
                } else {
                    out.write(ch)
                }
            }

            if (hadSlash) {
                out.write(92)
            }

        }
        return out.toString()
    }

}
