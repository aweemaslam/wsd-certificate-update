package com.solvians.showcase;

import com.solvians.showcase.generator.CertificateUpdateGenerator;
import com.solvians.showcase.model.CertificateUpdate;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CertificateUpdateGeneratorTest {

    @Test
     void generateQuotes() {
        CertificateUpdateGenerator generator = new CertificateUpdateGenerator(10, 100);
        Stream<CertificateUpdate> quotes = generator.generateQuotes();
        assertNotNull(quotes);
        assertEquals(100, quotes.count());
    }
}
