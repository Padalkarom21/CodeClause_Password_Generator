import java.security.SecureRandom;
import java.util.*;
public class q2 {
    private static final String UPPER_CASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

    public static String generatePassword(int length, boolean includeUpperCase, boolean includeLowerCase,
                                          boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        StringBuilder chars = new StringBuilder();
        if (includeUpperCase) {
            chars.append(UPPER_CASE_CHARS);
        }
        if (includeLowerCase) {
            chars.append(LOWER_CASE_CHARS);
        }
        if (includeNumbers) {
            chars.append(NUMBERS);
        }
        if (includeSpecialChars) {
            chars.append(SPECIAL_CHARS);
        }

        if (chars.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("How much no. of character password you want to generate: ");
        int length = sc.nextInt();
        boolean includeUpperCase = true;
        boolean includeLowerCase = true;
        boolean includeNumbers = true;
        boolean includeSpecialChars = true;

        String password = generatePassword(length, includeUpperCase, includeLowerCase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + password);
    }
}
