package Homeworks.Homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        String filePath = "Чччч.txt";

        try {
            String fileContent = readFile(filePath);
            System.out.println(fileContent);
        } catch (IOException e) {
            System.out.println("При чтении файла произошла ошибка: " + e.getMessage());
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return fileContent.toString();
    }
}
