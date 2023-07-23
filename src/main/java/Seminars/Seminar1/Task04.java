package Seminars.Seminar1;

import java.util.List;
import java.util.stream.IntStream;

public class Task04 {
    /*
    Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
    Метод должен пройтись по каждому элементу и проверить что он не равен null. Реализуйте следующую логику:

    1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя

    2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

     */
    public static void main(String[] args) {
        checkArray(new Integer[] {1,null,3,4,null,6,7,8});
    }

    public static void checkArray(Integer[] arr){
        List<Integer> indexes = IntStream
                .range(0, arr.length)
                .filter(i -> arr[i] == null)
                .boxed()
                .toList();
        if (indexes.size() > 0){
            throw new RuntimeException("Next cell is nulls " + indexes);
        }
        System.out.println("Array is not contains NULL");
    }
}
