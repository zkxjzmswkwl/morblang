package morb.lang;

import morb.lang.lex.MorbLex;

public class Morb {

    MorbLex morbiusLexicalAnalysisInator;
    private final int VERSION_MAJOR = 0;
    private final int VERSION_MINOR = 0;
    private final int VERSION_REVISION = 1;

    public Morb() {
        System.out.printf(
                "Morblang %d.%d.%d%n",
                VERSION_MAJOR,
                VERSION_MINOR,
                VERSION_REVISION
        );

        morbiusLexicalAnalysisInator = new MorbLex();
        morbiusLexicalAnalysisInator.morb();
    }

    public static void main(String[] args) {
        new Morb();
    }
}
