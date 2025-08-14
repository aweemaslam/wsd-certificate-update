package com.solvians.showcase.generator;

import com.solvians.showcase.model.CertificateUpdate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        return IntStream.range(0, threads * quotes)
            .parallel() // enables multithreading
            .mapToObj(i -> new CertificateUpdate()).limit(quotes);
    }
}
