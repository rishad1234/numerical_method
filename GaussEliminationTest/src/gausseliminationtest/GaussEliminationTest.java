
package gausseliminationtest;

import java.util.Scanner;

public class GaussEliminationTest {

    public static double[][] coefficients = new double[10][10];
    public static double[] rightSideVector = new double[10];
    public static double[] resultVector = new double[10];
    public static int status = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the system: ");
        size = input.nextInt();
        System.out.println("one row at a time");
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                coefficients[i][j] = input.nextDouble();
            }
        }
        
        System.out.println("Enter the input vectors: ");
        for(int i = 1; i <= size; i++){
            rightSideVector[i] = input.nextDouble();
        }
        
        gauss(size);
        
        if(status != 0){
            System.out.println("Solution vector: ");
            for(int i = 1; i <= size; i++){
                System.out.println(resultVector[i]);
            }
        }else{
            System.out.println("Singular matrix, reorder equations");
        }
    }
    
    public static void gauss(int size){
        double pivot, factor, sum;
        
        for(int k = 1; k <= size - 1; k++){
            pivot = coefficients[k][k];
            if(pivot < 0.000001){
                status = 0;
                return;
            }
            status = 1;
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
