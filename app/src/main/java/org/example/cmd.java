package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cmd {
    public static String run(String... args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(args);
        Process p = pb.start();

        String out = new String(p.getInputStream().readAllBytes());
        String err = new String(p.getErrorStream().readAllBytes());

        if (p.waitFor() != 0) {
            // throw new Exception("cmd.run retval != 0");
        }

        String result = "";
        result += out;
        if (!err.isEmpty() && !result.isEmpty()) { result += "\n"; }
        result += err;

        return result;
    }
}
