public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        return isLongEnough(password) &&
                containsDigit(password) &&
                containsLowerCaseLetter(password) &&
                containsUpperCaseLetter(password);
    }

    public static boolean isLongEnough(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperCaseLetter(String password) {
        return !password.equals(password.toLowerCase());
    }


    public static boolean containsLowerCaseLetter(String password) {
        return !password.equals(password.toUpperCase());
    }

    public static boolean isValidPasswordList(String[] passwords) {
        for (int i = 0; i < passwords.length; i++) {
            if (!isValidPassword(passwords[i])) {
                return false;
            }
        }
        return true;
    }
}
