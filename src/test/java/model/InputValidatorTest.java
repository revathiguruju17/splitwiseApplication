package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputValidatorTest {

    @Test
    void shouldReturnTrueForValidString(){
        assertTrue(InputValidator.isValidString( "friend" ));
    }

    @Test
    void shouldReturnFalseForAStringWhichConsistsOfOnlyDigits(){
        assertFalse(InputValidator.isValidString( "124556" ));
    }

    @Test
    void shouldReturnTrueForValidInteger(){
        assertTrue(InputValidator.isValidInteger( "200" ));
    }

    @Test
    void shouldReturnFalseForAStringWhichConsistsOfOnlyAlphabets(){
        assertFalse(InputValidator.isValidInteger( "lucky" ));
    }
}
