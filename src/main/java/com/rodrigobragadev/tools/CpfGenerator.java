package com.rodrigobragadev.tools;

import java.util.Random;

public class CpfGenerator {

    public static String generateCPF() {
        Random random = new Random();
        int[] cpf = new int[9];
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        cpf = appendDigit(cpf, calculateDigit(cpf, 10));
        cpf = appendDigit(cpf, calculateDigit(cpf, 11));

        return formatCPF(cpf);
    }

    private static int[] appendDigit(int[] cpf, int digit) {
        int[] newCpf = new int[cpf.length + 1];
        System.arraycopy(cpf, 0, newCpf, 0, cpf.length);
        newCpf[cpf.length] = digit;
        return newCpf;
    }

    private static int calculateDigit(int[] cpf, int weight) {
        int sum = 0;
        for (int i = 0; i < cpf.length; i++) {
            sum += cpf[i] * weight--;
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    private static String formatCPF(int[] cpf) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < cpf.length; i++) {
            formatted.append(cpf[i]);
            if (i == 2 || i == 5) formatted.append('.');
            else if (i == 8) formatted.append('-');
        }
        return formatted.toString();
    }
}