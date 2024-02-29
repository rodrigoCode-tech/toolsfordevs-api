package com.rodrigobragadev.tools;

public class CpfValidator {

    public static boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove non-digits.

        if (cpf.length() != 11 || hasAllDigitsEqual(cpf)) {
            return false;
        }

        for (int j = 9; j <= 10; j++) {
            int sum = 0, r;
            int num = 11 - j;
            for (int i = 0; i < j; i++) {
                sum += Integer.parseInt(cpf.substring(i, i + 1)) * (num--);
            }
            r = (sum * 10) % 11;
            if (r == 10) r = 0;
            if (r != Integer.parseInt(cpf.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasAllDigitsEqual(String cpf) {
        return cpf.chars().allMatch(c -> c == cpf.charAt(0));
    }
}