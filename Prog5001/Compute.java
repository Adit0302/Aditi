package Prog5001;
import java.util.ArrayList;
public class Compute
{
       // Compute mean of the marks
    public static double mean(ArrayList<Double> marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.size();
    }
          // Calculate standard deviation
    public static double standardDeviation(ArrayList<Double> marks, double mean) {
        double sumSquaredDiff = 0;
        for (double mark : marks) {
            double diff = mark - mean;
            sumSquaredDiff += diff * diff;
        }
        double variance = sumSquaredDiff / marks.size();
        return Math.pow(variance, 0.5); 
    }
}
