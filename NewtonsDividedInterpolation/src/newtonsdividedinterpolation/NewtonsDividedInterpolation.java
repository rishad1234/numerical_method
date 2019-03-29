
package newtonsdividedinterpolation;

import java.util.Scanner;

public class NewtonsDividedInterpolation {

    public static double[] x = new double[1000];
    public static double[] y = new double[1000];
    public static double[][] differenceTable = new double[1000][1000];
    public static double[] interpolationPolynomial = new double[1000];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of data poins: ");
        int dataPoints = input.nextInt();
        System.out.println("Enter the values of xi and yi");
        for(int i = 1; i <= dataPoints; i++){
            x[i] = input.nextDouble();
            y[i] = input.nextDouble();
        }
        
        //difference table
        for(int i = 1; i <= dataPoints; i++){
            differenceTable[i][1] = y[i];
        }
        
        for(int j = 2; j <= dataPoints; j++){
            for(int i = 1; i <= dataPoints - j + 1; i++){
                differenceTable[i][j] = (differenceTable[i + 1][j - 1] - differenceTable[i][j - 1]) / (x[i + j - 1] - x[i]);
            }
        }
        
        //set the coefficients of the interpolation polynomial
        for(int i = 1; i <= dataPoints; i++){
            interpolationPolynomial[i] = differenceTable[1][i];
        }
        
        //computer the interpolation value
        System.out.println("Enter the value for the interpolation: ");
        double interpolationValue = input.nextDouble();
        double sum = interpolationPolynomial[1];
        for(int i = 2; i <= dataPoints; i++){
            double temp = 1.0;
            for(int j = 1; j <= i - 1; j++){
                temp *= interpolationValue - x[j];
            }
            sum += interpolationPolynomial[i] * temp;
        }
        
        System.out.println("The interpolated answer is: " + sum);
    } 
}
