import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "password, true",
            "passwor, false",
            "password123, true"
    })
    public void testIsLongEnough(String password, boolean expected){
        //WHEN
        boolean actual = PasswordValidator.isLongEnough(password);

        //THEN
        assertEquals(expected, actual);
    }

}