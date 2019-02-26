
package gaussjordantest;

import java.util.Scanner;

public class GaussJordanTest {
    public static double[][] ar = new double[100][100];
    public static double[] resultVector = new double[100];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of the system: ");
        int n = input.nextInt();
        System.out.println("Enther the coefficients: ");
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n + 1; j++){
                ar[i][j] = input.nextDouble();
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i != j){
                    double temp = ar[j][i] / ar[i][i];
                    for(int k = 1; k <= n + 1; k++){
                        ar[j][k] = ar[j][k] - temp * ar[i][k];
                    }
                }
            }
        }
        
        System.out.println("The solution is:");
        for(int i = 1; i <= n; i++){
            resultVector[i] = ar[i][n+1] / ar[i][i];
            System.out.println(resultVector[i]);
        }
    }
}
