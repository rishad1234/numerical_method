
package gausseliminationtest;

import java.util.Scanner;

public class GaussEliminationTest {

    public static double[][] a = new double[10][10];
    public static double[] b = new double[10];
    public static double[] x = new double[10];
    public static int status = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of the system: ");
        n = input.nextInt();
        System.out.println("one row at a time");
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                a[i][j] = input.nextDouble();
            }
        }
        
        System.out.println("Enter the input vectors: ");
        for(int i = 1; i <= n; i++){
            b[i] = input.nextDouble();
        }
        
        gauss(n);
        
        if(status != 0){
            System.out.println("Solution vector: ");
            for(int i = 1; i <= n; i++){
                System.out.println(x[i]);
            }
        }else{
            System.out.println("Singular matrix, reorder equations");
        }
    }
    
    public static void gauss(int n){
        double pivot, factor, sum;
        
        for(int k = 1; k <= n - 1; k++){
            pivot = a[k][k];
            if(pivot < 0.000001){
                status = 0;
                return;
            }
            status = 1;
            for(int i = k + 1; i <= n; i++){
                factor = a[i][k] / pivot;
                for(int j = k + 1; j <= n; j++){
                    a[i][j] = a[i][j] - factor * a[k][j];
                }
                b[i] = b[i] - factor * b[k];
            }
        }
        
        x[n] = b[n] / a[n][n];
        for(int k = n - 1; k >= 1; k--){
            sum = 0.0;
            for(int j = k + 1; j <= n; j++){
                sum = sum + a[k][j] * x[j];
            }
            x[k] = (b[k] - sum) / a[k][k];
        }
    }
}
