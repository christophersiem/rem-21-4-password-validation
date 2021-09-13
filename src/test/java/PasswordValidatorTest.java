import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "password, true",
            "passwor, false",
            "password123, true"
    })
    public void testIsLongEnough(String password, boolean expected) {
        //WHEN
        boolean actual = PasswordValidator.isLongEnough(password);

        //THEN
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "test1, true",
            "password, false",
            "password123, true"
    })
    public void testContainsDigit(String password, boolean expected) {
        //WHEN
        boolean actual = PasswordValidator.containsDigit(password);

        //THEN
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "test1, false",
            "passWord, true",
            "passWORD, true",
            "12345678, false",
            "Üabcdefgh, true",
    })
    public void testContainsUppercaseLetter(String password, boolean expected) {
        //WHEN
        boolean actual = PasswordValidator.containsUpperCaseLetter(password);

        //THEN
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "test1, true",
            "passWord, true",
            "PASSWORD, false"
    })
    public void testContainsLowercaseLetter(String password, boolean expected) {
        //WHEN
        boolean actual = PasswordValidator.containsLowerCaseLetter(password);

        //THEN
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "testPW121, true",
            "passWord, false",
            "PASSWORD123, false",
    })
    public void testValidatePassword(String password, boolean expected) {
        //WHEN
        boolean actual = PasswordValidator.isValidPassword(password);

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void testIsValidPasswordList() {
        //GIVEN
        String[] passwords = {"passWORD1", "passWORD123"};

        //WHEN
        boolean actual = PasswordValidator.isValidPasswordList(passwords);

        //THEN
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testIsValidPasswordListMethodSource(String[] passwords, boolean expected) {

        //WHEN
        boolean actual = PasswordValidator.isValidPasswordList(passwords);

        //THEN
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> getArguments() {
        return Stream.of(Arguments.arguments(
                new String[]{"passwoRD123", "test123Hallo"}, true,
                new String[]{"pasRD123", "test123Hallo"}, false,
                new String[]{"passWORD", "test123Hallo"}, false
        ));
    }


}