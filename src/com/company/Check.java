package com.company;

import java.util.StringTokenizer;

public class Check {
    public static boolean isValid(String str, char lowerBound, char upperBound) {
        str = str.trim().toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= lowerBound && str.charAt(i) <= upperBound)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String str, char lowerBoud, char upperBound, String delimiter) {
        StringTokenizer token = new StringTokenizer(str, delimiter, false);
        if (token.countTokens() > 2) {
            return false;
        }
        String integerPart = token.nextToken();
        String decimalPart = null;
        if (token.hasMoreTokens()) {
            decimalPart = token.nextToken();
        }
        if (!isValid(integerPart, '0', '9')) {
            return false;
        }
        if (decimalPart != null && !isValid(decimalPart, '0', '9')) {
            return false;
        }

        return true;
    }
}
