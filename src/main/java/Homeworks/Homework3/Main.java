package Homeworks.Homework3;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол):");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        if (data.length != 6) {
            System.err.println("Ошибка: неверное количество данных");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            validateData(dateOfBirth, phoneNumber, gender);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return;
        }

        String fileName = surname + ".txt";
        String fileContent = surname + name + patronymic + dateOfBirth + " " + phoneNumber + gender;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(fileContent);
            writer.newLine();
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateData(String dateOfBirth, String phoneNumber, String gender) {
        validateDateFormat(dateOfBirth);
        validatePhoneNumber(phoneNumber);
        validateGender(gender);
    }

    private static void validateDateFormat(String dateOfBirth) {
        String[] parts = dateOfBirth.split("\\.");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Некорректный день");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Некорректный месяц");
        }

        if (year < 1900 || year > 2023) {
            throw new IllegalArgumentException("Некорректный год");
        }
    }

    private static void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{10,15}")) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
    }

    private static void validateGender(String gender) {
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new IllegalArgumentException("Неверное значение пола");
        }
    }
}
