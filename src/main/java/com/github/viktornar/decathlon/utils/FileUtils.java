package com.github.viktornar.decathlon.utils;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.github.viktornar.decathlon.constants.Constants.ACCESS_DENIED_EXCEPTION;
import static com.github.viktornar.decathlon.constants.Constants.BUFFER_SIZE;
import static com.github.viktornar.decathlon.constants.Constants.XSLT_FILE_NAME;

/**
 * Utils related to file write and read operations
 *
 * @author v.nareiko
 */
public class FileUtils {
    /**
     * Read data by given file path
     *
     * @param filePath - path to file
     * @return - file content converted to List<String>
     */
    public static List<String> readData(String filePath) {
        return readData(new File(filePath));
    }

    /**
     * Read data by given file
     *
     * @param input - file to read data from
     * @return - file content converted to List<String>
     */
    public static List<String> readData(File input) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    /**
     * Write data to given output
     *
     * @param output      - output as path to file where data should be wrote
     * @param dataToWrite - data to be written
     */
    private static void writeData(String output, String dataToWrite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            bw.write(dataToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write data to given output
     *
     * @param output      - output as file where data should be wrote
     * @param dataToWrite - data to be written
     */
    public static void writeData(File output, String dataToWrite) {
        try {
            if (!Files.isDirectory(output.toPath())) {
                writeData(output.getAbsolutePath(), dataToWrite);
            } else {
                throw new AccessDeniedException(ACCESS_DENIED_EXCEPTION);
            }
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copy input stream to file
     *
     * @param inputStream  - input stream
     * @param output - target (output) file
     */
    public static void copy(InputStream inputStream, File output) {
        try {
            if (!Files.isDirectory(output.toPath())) {
                String absolutePath = output.getAbsolutePath();
                String target = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator))
                        + File.separator
                        + XSLT_FILE_NAME;
                OutputStream outputStream = new FileOutputStream(target);
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = inputStream.read(buffer);
                while (bytesRead != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    bytesRead = inputStream.read(buffer);
                }
                outputStream.close();
                inputStream.close();
            } else {
                throw new AccessDeniedException(ACCESS_DENIED_EXCEPTION);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


