package com.solvians.showcase.generator;

import java.util.concurrent.ThreadLocalRandom;

public class ISINGenerator {

    private static final char[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final String ALPHA_NUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String generateISIN() {
        StringBuilder sb = new StringBuilder();

        // 2 random uppercase alphabets
        sb.append(LETTERS[ThreadLocalRandom.current().nextInt(LETTERS.length)]);
        sb.append(LETTERS[ThreadLocalRandom.current().nextInt(LETTERS.length)]);

        // 9 random alphanumeric characters (0-9, A-Z)
        for (int i = 0; i < 9; i++) {
            sb.append(ALPHA_NUMERIC_CHARS.charAt(ThreadLocalRandom.current().nextInt(ALPHA_NUMERIC_CHARS.length())));
        }

        // 1 check digit
        int checkDigit = calculateCheckDigit(sb.toString());
        sb.append(checkDigit);

        return sb.toString();
    }

    public static int calculateCheckDigit(String isin) {
        StringBuilder numericString = new StringBuilder();
        // converting chars to numbers
        for (char c : isin.toCharArray()) {
            if (Character.isLetter(c)) {
                numericString.append(letterToNumber(c));
            } else {
                numericString.append(c);
            }
        }

        // reverse the string
        String reversed = numericString.reverse().toString();
        int sum = 0;
        boolean alternate = false;
        for (int i = 0; i < reversed.length(); i++) {
            int digit = Character.getNumericValue(reversed.charAt(i));
            if (alternate) {
                digit *= 2;
            }
            if (digit > 9) {
                sum += digit / 10 + digit % 10;
            } else {
                sum += digit;
            }
            if(alternate) {
                alternate = false;
            } else {
                alternate = true;
            }
        }
        return nextMultipleOf10(sum) - sum;
    }
    public static int nextMultipleOf10(int number) {
        return ((number + 9) / 10) * 10;
    }
    private static int letterToNumber(char c) {
        return c - 'A' + 10;
    }
}
