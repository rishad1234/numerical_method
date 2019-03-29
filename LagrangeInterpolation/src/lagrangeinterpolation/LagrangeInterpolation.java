
package lagrangeinterpolation;

import java.util.Scanner;

public class LagrangeInterpolation {
    public static double[] x = new double[1000];
    public static double[] y = new double[1000];
    public static double interpolatedValue;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of data points: ");
        int dataPoints = input.nextInt();
        System.out.println("Enter the data in xi and yi one by one: ");
        for(int i = 0; i < dataPoints; i++){
            x[i] = input.nextDouble();
            y[i] = input.nextDouble();
        }
        System.out.println("Enter the value for the inpterpolation: ");
        double interplationValue = input.nextDouble();
        double numerator = 1.0;
        double denominator = 1.0;
        for(int i = 0; i < dataPoints; i++){
            for(int j = 0; j < dataPoints; j++){
                if(i != j){
                    numerator *= (interplationValue - x[j]);
                    denominator *= (x[i] - x[j]);
                }
            }
            interpolatedValue += (numerator / denominator) * y[i];
            numerator = 1.0;
            denominator = 1.0;
        }
        System.out.println("The interpolated answer is : " + interpolatedValue);     
    }
    
}
