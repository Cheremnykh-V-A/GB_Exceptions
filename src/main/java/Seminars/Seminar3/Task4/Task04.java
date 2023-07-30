package Seminars.Seminar3.Task4;

import java.util.ArrayList;
import java.util.List;

/**
 Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось
 (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 с детализацией, в какой именно ячейке лежат неверные данные.

 2. В методе main() вызвать полученный метод, обработать возможные исключения
 MyArraySizeException и MyArrayDataException и вывести результат расчета
 (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task04 {
    static String[][] arr = new String[][] {
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"}
    };

    public static void main(String[] args) {
        System.out.println(sum2d(arr));
    }

    public static double sum2d(String[][] arr) {
        if (isNotSquareArray(arr)) throw new MyArraySizeException();

        List<Goal> goals = new ArrayList<>();
        double count = 0;

        for (int i = 0; i < arr.length; i++) {
            String[] strings = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (isNotDigit(arr[i][j])) {
                    Goal g = new Goal(i, j);
                    goals.add(g);
                } else {
                    count += Double.parseDouble(strings[j]);
                }

            }
        }

        if (goals.size() != 0) throw new MyArrayDataException(goals);

        return count;
    }

    private static boolean isNotSquareArray(String[][] arr) {
        if (arr.length != 3) return true;
        for (String[] elem : arr) {
            if (elem.length != arr.length) return true;
        }
        return false;
    }

    private static boolean isNotDigit(String s) {
        try {
            Double.parseDouble(s);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}