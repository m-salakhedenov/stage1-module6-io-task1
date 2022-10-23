package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String rawProfileData = getRawData(file);

        if (rawProfileData != null) {
            ProfileParser parser = new ProfileParser(rawProfileData);
            return parser.parse();
        }

        return null;
    }

    private String getRawData(File file) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            StringBuilder fileData = new StringBuilder();

            int c;
            while ((c = reader.read()) != -1) {
                fileData.append((char) c);
            }

            return fileData.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
