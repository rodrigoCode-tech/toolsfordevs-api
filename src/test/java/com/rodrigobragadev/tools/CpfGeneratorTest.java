package com.rodrigobragadev.tools;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpfGeneratorTest {

    private CpfValidator CpfValidator;


    @Test
    public void testCpfFormat() {
        String cpf = CpfGenerator.generateCPF();
        assertTrue(cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"), "CPF não está no formato esperado");
    }


    //@Test
    public void testCpfValidity() {
        for (int i = 0; i < 100; i++) {
            String cpf = CpfGenerator.generateCPF();
            assertTrue(CpfValidator.isValidCPF(cpf), "CPF inválido gerado: " + cpf);
        }
    }
}