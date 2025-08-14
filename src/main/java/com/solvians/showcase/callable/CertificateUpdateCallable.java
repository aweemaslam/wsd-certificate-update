package com.solvians.showcase.callable;

import com.solvians.showcase.model.CertificateUpdate;
import java.util.concurrent.Callable;

public class CertificateUpdateCallable implements Callable<String> {

    @Override
    public String call() {
        CertificateUpdate update = new CertificateUpdate();
        return update.generateUpdateCertificate();
    }
}
