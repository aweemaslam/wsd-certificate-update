package com.solvians.showcase;

import com.solvians.showcase.model.CertificateUpdate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertificateUpdateTest {

    @Test
    void testGenerateUpdateCertificate() {
        CertificateUpdate update = new CertificateUpdate();
        String csv = update.generateUpdateCertificate();
        assertNotNull(csv);
        String[] parts = csv.split(",");
        assertEquals(6, parts.length);
    }
}
