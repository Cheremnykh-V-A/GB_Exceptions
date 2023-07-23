package Seminars.Seminar1;

public class Program {
    /*
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
    Если длина массива меньше некоторого заданного минимума,
    метод возвращает -1, в качестве кода ошибки,
    иначе - длину массива.
     */
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,78,9,5};
        System.out.println(checkLength(array, 5));
        System.err.println(); // serr -shortcut
    }

    public static int checkLength(int[] array,int min ){
        if(array.length < min){
            return -1;
        }
        return array.length;
    }
}
