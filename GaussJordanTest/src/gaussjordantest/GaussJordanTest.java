
package gaussjordantest;

import java.util.Scanner;

public class GaussJordanTest {
    public static double[][] ar = new double[100][100];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of the system: ");
        int n = input.nextInt();
        System.out.println("Enther the coefficients: ");
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n + 1; j++){
                ar[i][j] = input.nextDouble();
            }
        }
        
        for(int i = 0; i < n; i++){
            double x = ar[i][i];
            
            for(int j = 0; j < n + 1; j++){
                ar[i][j] = ar[i][j] / x;
            }
            
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                double temp = ar[j][i];
                
                for(int k = 0; k < n + 1; k++){
                    ar[j][k] = ar[j][k] - ar[i][k] * temp;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            System.out.println(ar[i][n]);
        }
    }
}
