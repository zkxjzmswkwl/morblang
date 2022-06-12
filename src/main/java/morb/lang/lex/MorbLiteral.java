package morb.lang.lex;
/*
 * --------------------
 * Authored by: Carter
 * Timestamp: 6/12/2022
 * --------------------
 * Edit by: No one, yet.
 * Timestamp: nil
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MorbLiteral {
    private Object value;
    private int lineFoundOn;
}
