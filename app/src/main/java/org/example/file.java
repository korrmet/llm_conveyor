package org.example;

import java.io.*;

public class file {
    public static String read(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String result = new String();
        String line;
        while ((line = reader.readLine()) != null) { result += line + "\n"; }
        result = result.substring(0, result.length() - 1);
        reader.close();
        return result;
    }

    public static void write(String path, String data) throws Exception {
        FileWriter writer = new FileWriter(path);
        writer.write(data);
        writer.close();
    }
}
