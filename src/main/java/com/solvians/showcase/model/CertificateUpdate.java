package com.solvians.showcase.model;

import com.solvians.showcase.generator.ISINGenerator;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdate {

    private final long timestamp; // timestamp in milliseconds
    private final String isin;
    private final double bidPrice;
    private final int bidSize;
    private final double askPrice;
    private final int askSize;

    public CertificateUpdate() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        this.timestamp = System.currentTimeMillis();
        this.isin = ISINGenerator.generateISIN();
        this.bidPrice = Math.round((100.00 + random.nextDouble(100.00)) * 100.0) / 100.0;
        this.bidSize = random.nextInt(1000, 5001);
        this.askPrice = Math.round((100.00 + random.nextDouble(100.00)) * 100.0) / 100.0;
        this.askSize = random.nextInt(1000, 10001);
    }

    public String generateUpdateCertificate() {
        return String.format("%d,%s,%.2f,%d,%.2f,%d",
                timestamp, isin, bidPrice, bidSize, askPrice, askSize);
    }
}
