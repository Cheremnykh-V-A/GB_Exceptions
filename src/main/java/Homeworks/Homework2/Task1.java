package Homeworks.Homework2;

import java.util.Scanner;

public class Task1 {
    /*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
    вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */
    public static void main(String[] args) {
        float number = getFloatInput();
        System.out.println("Введённое число: " + number);
    }

    public static float getFloatInput(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите дробное число");
            try {
                float input = Float.parseFloat(scanner.nextLine());
                return input;
            } catch (NumberFormatException e){
                System.out.println("Некорректный ввод. Введите дробное число");
            }
        }
    }

}
