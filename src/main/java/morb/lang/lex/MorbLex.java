package morb.lang.lex;

/*
 * --------------------
 * Authored by: Carter
 * Timestamp: 6/12/2022
 * --------------------
 * Edit by: No one, yet.
 * Timestamp: nil
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;

public class MorbLex {

    private record MorbTokenValue(MorbToken token, String value){};
    private List<String> morbIn;

    private HashMap<String, Object> MORB_TYPES = new HashMap<>() {{
        put("int", Integer.class);
        put("long", Long.class);
        put("str", String.class);
        put("decimorb", Double.class);
    }};

    private HashMap<String, MorbToken> MORB_TOKENS = new HashMap<>() {{
        put("MORB", MorbToken.SEPARATOR);                  // { equivalent
        put("BROM", MorbToken.SEPARATOR);                  // } equivalent
        put("!", MorbToken.SEPARATOR);                     // line end
        put("|", MorbToken.SEPARATOR);                     // ( and ) equivalent
        put("morbin_time", MorbToken.KEYWORD);             // Function evoker. Otherwise known as "The Evoker"
        put("if", MorbToken.KEYWORD);                      // Open to interpretation
        put("wow", MorbToken.KEYWORD);                     // Open to interpretation
        put("imgonna", MorbToken.KEYWORD);                 // Open to interpretation
        put("[__v(-_-)v__]", MorbToken.COMMENT);           // Comment
        put("[__v(^_^)v__]", MorbToken.COMMENT);           // Multi-line comment start
        put("[__v(v_v)v__]", MorbToken.COMMENT);           // Multi-line comment end
    }};

    private HashMap<String, MorbLiteral> literalMap;

    public MorbLex() {
        literalMap = new HashMap<>();
    }

    public void drMorbPleaseAnalyzeThis(String line) throws IOException {
        Path testFile = Paths.get("test.morb.jit");
        Matcher identifierMatcher = MorbToken.IDENTIFIER.getPattern().matcher(line);
        Matcher keywordMatcher    = MorbToken.KEYWORD.getPattern().matcher(line);
        Matcher separatorMatcher  = MorbToken.SEPARATOR.getPattern().matcher(line);
        Matcher commentMatcher    = MorbToken.COMMENT.getPattern().matcher(line);

        if (commentMatcher.find())
            return;

        StringBuilder jitOutput = new StringBuilder();

        if (keywordMatcher.find()) {
            // TODO: Probably iterate over each matcher's groups.
            jitOutput.append(keywordMatcher.group(0) + "\n");
        }

        if (identifierMatcher.find()) {
            jitOutput.append(identifierMatcher.group(1) + "\n");
        }

        if (separatorMatcher.find()) {
            for (int i = 0; i <= separatorMatcher.groupCount(); i++) {
                jitOutput.append(separatorMatcher.group(i) + "\n");
            }
        }

        Files.write(testFile, jitOutput.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public void morb() {
        Path p = Paths.get("test.morb");

        try {
            this.morbIn = Files.readAllLines(p);

            for (int i = 0; i < this.morbIn.size(); i++) {
                this.drMorbPleaseAnalyzeThis(this.morbIn.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
