
package polynomialregression;

import java.util.Scanner;

public class PolynomialRegression {
    
    public static double[][] coefficients = new double[10][10];
    public static double[] rightSideVector = new double[10];
    public static double[] resultVector = new double[10];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int points = input.nextInt();
        double x[] = new double[100];
        double y[] = new double[100];
        System.out.println("Enter the values of x and y one by one: ");
        for(int i = 1; i <= points; i++){
            x[i] = input.nextDouble();
            y[i] = input.nextDouble();
        }
        System.out.println("Enter the order of the polynomial: ");
        int order = input.nextInt();
        int equations = order + 1;
        
        for(int i = 1; i <= equations; i++){
            for(int j = 1; j <= equations; j++){
                int power = i + j - 2;
                for(int k = 1; k <= points; k++){
                    coefficients[i][j] += Math.pow(x[k], power);
                }
            }
        }
        
        for(int i = 1; i <= equations; i++){
            int power = i - 1;
            for(int j = 1; j <= points; j++){
                rightSideVector[i] += y[j] + Math.pow(x[j], power);
            }
        }
        
        gauss(equations);
        
        for(int i = 1; i <= equations; i++){
            System.out.println(resultVector[i]);
        }
    }
    
    public static void gauss(int size){
        double pivot, factor, sum;
        for(int k = 1; k <= size - 1; k++){
            pivot = coefficients[k][k];
            for(int i = k + 1; i <= size; i++){
                factor = coefficients[i][k] / pivot;
                for(int j = k + 1; j <= size; j++){
                    coefficients[i][j] = coefficients[i][j] - factor * coefficients[k][j];
                }
                rightSideVector[i] = rightSideVector[i] - factor * rightSideVector[k];
            }
        }
        
        resultVector[size] = rightSideVector[size] / coefficients[size][size];
        for(int k = size - 1; k >= 1; k--){
            sum = 0.0;
            for(int j = k + 1; j <= size; j++){
                sum = sum + coefficients[k][j] * resultVector[j];
            }
            resultVector[k] = (rightSideVector[k] - sum) / coefficients[k][k];
        }
    }
}
