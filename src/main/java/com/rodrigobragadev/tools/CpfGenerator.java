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
    public static String generateCNPJ() {
        Random random = new Random();
        int[] cnpj = new int[12];
        for (int i = 0; i < 8; i++) {
            cnpj[i] = random.nextInt(10);
        }

        cnpj = appendDigitCNPJ(cnpj, calculateDigitCNPJ(cnpj, 5));
        cnpj = appendDigitCNPJ(cnpj, calculateDigitCNPJ(cnpj, 6));

        return formatCNPJ(cnpj);
    }

    private static int[] appendDigitCNPJ(int[] cnpj, int digit) {
        int[] newCnpj = new int[cnpj.length + 1];
        System.arraycopy(cnpj, 0, newCnpj, 0, cnpj.length);
        newCnpj[cnpj.length] = digit;
        return newCnpj;
    }

    private static int calculateDigitCNPJ(int[] cnpj, int weight) {
        int sum = 0;
        for (int i = 0; i < cnpj.length; i++) {
            sum += cnpj[i] * weight--;
            if (weight == 1) {
                weight = 9;
            }
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    private static String formatCNPJ(int[] cnpj) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < cnpj.length; i++) {
            formatted.append(cnpj[i]);
            if (i == 1 || i == 4) formatted.append('.');
            else if (i == 7) formatted.append('/');
            else if (i == 11) formatted.append('-');
        }
        return formatted.toString();
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