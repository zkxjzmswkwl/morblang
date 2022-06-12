package morb.lang.lex;

import lombok.Getter;

import java.util.regex.Pattern;

public enum MorbToken {
    KEYWORD(Pattern.compile("if|morbin_time|wow|imgonna")),
    IDENTIFIER(Pattern.compile("\\|(.*?)\\|")),
    SEPARATOR(Pattern.compile("!|MORB|BROM")),
    COMMENT(Pattern.compile("\\[__v\\(-_-\\)v__\\]|\\[__v\\(\\^_\\^\\)v__\\]|\\[__v\\(v_v\\)v__\\]"));  // Lol

    @Getter
    public Pattern pattern;

    MorbToken(Pattern pattern) {
        this.pattern = pattern;
    }
}
