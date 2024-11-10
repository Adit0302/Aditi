package Prog5001;
import java.util.ArrayList;
import java.util.Scanner;
public class Bsort
{
    // Bubble sort algorithm to arrange marks in ascending order
    public static void bSort(ArrayList<Double> marks) {
        int n = marks.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks.get(j) > marks.get(j + 1)) {
                    double temp = marks.get(j);
                    marks.set(j, marks.get(j + 1));
                    marks.set(j + 1, temp);
                }
            }
        }
    }
}
