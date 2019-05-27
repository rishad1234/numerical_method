
package gaussseidel;

import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class GaussSeidel {

    static double[][] a = new double[10][10];
    static double[] b = new double[10];
    static double[] x = new double[10];
    static int count, status;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of the system: ");
        int n = input.nextInt();
        
        System.out.println("Enter the coefficients row by row: ");
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                a[i][j] = input.nextDouble();
            }
        }
        
        System.out.println("Enter the input vector: ");
        for(int i = 1; i <= n; i++){
            b[i] = input.nextDouble();
        }
        
        gaussSeidel(n);
        
        if(status == 2){
            System.out.println("No convergence in the selective iterations"); 
        }else{
            System.out.println("Solution vector: ");
            for(int i = 1; i <= n; i++){
                System.out.format("%.2f ", x[i]);
            }
            System.out.println("");
            System.out.println("Iteration count: " + count);
        }
        
    }
    
    public static void gaussSeidel(int n){
        int key;
        double sum;
        double x0[] = new double[10];
        
        for(int i = 1; i <= n; i++){
            x0[i] = b[i] / a[i][i];
        }
        
        count = 1;
        while(count < 50){
            key = 0;
            for(int i = 1; i <= n; i++){

                sum = b[i];
                for(int j = 1; j <= n; j++){
                    if(i == j){
                        continue;
                    }
                    sum = sum - a[i][j] * x0[j];
                }

                x[i] = sum / a[i][i];
                
                if(key == 0){
                    if(Math.abs((x[i] - x0[i]) / x[i]) > 0.000001){
                        key = 1;
                    }
                }
            }

            if(key == 1){
                if(count == 50){
                    status = 2;
                    break;
                }else{
                    status = 1;
                    for(int i = 1; i <= n; i++){
                        x0[i] = x[i];
                    }
                }
                count++;
            }
        }
    }
    
}
