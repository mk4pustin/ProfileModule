package ru.sber.kapustin.homework1;

import java.io.*;

public class FileTextConverter {
    public final static int LOWER_CASE_A_CODE = 'a';
    public final static int LOWER_CASE_Z_CODE = 'z';

    public final static String DEFAULT_INPUT_FILE_NAME = "./input.txt";
    public final static String DEFAULT_OUTPUT_FILE_NAME = "./output.txt";


    public static void convertToUpperCase() {
        convertToUpperCase(DEFAULT_INPUT_FILE_NAME, DEFAULT_OUTPUT_FILE_NAME);
    }

    public static void convertToUpperCase(String inputFileName, String outputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.chars()
                        .map(c -> c >= LOWER_CASE_A_CODE && c <= LOWER_CASE_Z_CODE? Character.toUpperCase(c) : c)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Log: " + e.getMessage());
        }
    }
}
