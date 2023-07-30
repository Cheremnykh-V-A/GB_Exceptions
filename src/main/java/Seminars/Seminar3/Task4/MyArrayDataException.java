package Seminars.Seminar3.Task4;

import java.util.List;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j) {
        super(String.format("В ячейке [%s][%s] не число!", i, j));
    }

    public MyArrayDataException(List<Goal> goals) {
        super(String.format("В ячейках %s не число!", goals));
    }
}