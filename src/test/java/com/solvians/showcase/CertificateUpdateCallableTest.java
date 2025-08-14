package com.solvians.showcase;

import com.solvians.showcase.callable.CertificateUpdateCallable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertificateUpdateCallableTest {

    @Test
    void testCall() {
        CertificateUpdateCallable callable = new CertificateUpdateCallable();
        String cert = callable.call();
        assertNotNull(cert);
        assertEquals(6, cert.split(",").length);
    }
}
