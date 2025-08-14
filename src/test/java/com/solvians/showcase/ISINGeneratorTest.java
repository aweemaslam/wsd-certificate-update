package com.solvians.showcase;

import com.solvians.showcase.generator.ISINGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISINGeneratorTest {

    @Test
    void testISINFormat() {
        String isin = ISINGenerator.generateISIN();
        assertNotNull(isin);
        assertEquals(12, isin.length());
        assertTrue(isin.matches("^[A-Z]{2}[A-Z0-9]{9}\\d$"));
    }

    @Test
    void testCheckDigitCalculation() {
        String partial = "DE123456789";
        int checkDigit = ISINGenerator.calculateCheckDigit(partial);
        assertTrue(checkDigit >= 0 && checkDigit <= 9);
    }
}
