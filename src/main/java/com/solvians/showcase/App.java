package com.solvians.showcase;

import com.solvians.showcase.generator.CertificateUpdateGenerator;
import com.solvians.showcase.model.CertificateUpdate;
import java.util.stream.Stream;

public class App {
    public App(String threads, String quotes) {
        generate(Integer.parseInt(threads), Integer.parseInt(quotes));
    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            int threads = Integer.parseInt(args[0]);
            int quotes = Integer.parseInt(args[1]);

            generate(threads, quotes);
        } else {
            throw new RuntimeException("Expect at least number of threads and number of quotes. But got: " + args);
        }
    }

    private static void generate(int threads, int quotes) {
        CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(threads, quotes);
        Stream<CertificateUpdate> certificateUpdateStream = certificateUpdateGenerator.generateQuotes();
        certificateUpdateStream.forEach(cert-> {
            System.out.println(cert.generateUpdateCertificate());
        });
    }
}
