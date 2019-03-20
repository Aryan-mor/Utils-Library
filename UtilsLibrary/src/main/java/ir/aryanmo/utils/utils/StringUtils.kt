package ir.aryanmo.utils.utils

import java.util.regex.Pattern


fun toTitleCase(s: String): String {
        var space = true
        val builder = StringBuilder(s)
        val len = builder.length

        for (i in 0 until len) {
            val c = builder[i]
            if (space) {
                if (!Character.isWhitespace(c)) {
                    builder.setCharAt(i, Character.toTitleCase(c))
                    space = false
                }
            } else if (Character.isWhitespace(c)) {
                space = true
            } else {
                builder.setCharAt(i, Character.toLowerCase(c))
            }
        }

        return builder.toString()
    }

    private fun toTitleCase1(s: String): String {
        var s = s
        //<a>Ali</a> not cover
        val matcher = Pattern.compile("(\\s[a-z]\\w*)").matcher(s)
        while (matcher.find()) {
            var t = matcher.group(0)
            t[1].toUpperCase() + t.substring(2)
        }
        return s
    }

    fun removeAllSpaces(s: String): String {
        return s.replace(" ", "")
    }
