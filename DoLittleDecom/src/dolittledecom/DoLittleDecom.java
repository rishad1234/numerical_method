
package dolittledecom;

import java.util.Scanner;

public class DoLittleDecom {

    static final int YES = 1;
    static final int NO = 0;
    
    static int n, fact;
    static double [][] a = new double[10][10];
    static double [][] u = new double[10][10];
    static double [][] l = new double[10][10];
    static double [] b = new double[10];
    static double [] x = new double[10];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of A: ");
        n = input.nextInt();
        
        System.out.println("Type the coefficients row by row: ");
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                a[i][j] = input.nextDouble();
            }
        }
        System.out.println("type the vector B is one line: ");
        for(int i = 1; i <= n; i++){
            b[i] = input.nextDouble();
        }
        
        lud();
        if(fact == YES){
            System.out.println("U matrix: ");
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    System.out.format("%.2f ", u[i][j]);
                }
                System.out.println("");
            }
            
            System.out.println("L matrix: ");
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    System.out.format("%.2f ", l[i][j]);
                }
                System.out.println("");
            }
            
            solve();
            System.out.println("Solution vector: ");
            for(int i = 1; i <= n; i++){
                System.out.format("%.2f ", x[i]);
            }
        }else{
            System.out.println("Not possible.");
        }
    }
    
    private static void lud(){
        double sum;
        int i, j, k;
        for(j = 1; j <= n; j++){
            u[1][j] = a[1][j];
        }
        
        for(i = 1; i <= n; i++){
            l[i][i] = 1.0;
        }
        
        for(i = 1; i <= n; i++){
            l[i][1] = a[i][1] / u[1][1];
        }
        
        for(j = 2; j <= n; j++){
            for(i = 2; i <= j; i++){
                sum = a[i][j];
                
                for(k = 1; k <= i - 1; k++){
                    sum = sum - l[i][k] * u[k][j];
                    u[i][j] = sum;
                }
            }
            
            if(u[j][j] <= 0.0000001){
                fact = NO;
                return;
            }
            
            for(i = j + 1; i <= n; i++){
                sum = a[i][j];

                for(k = 1; k <= j - 1; k++){
                    sum = sum - l[i][k] * u[k][j];
                }
                l[i][j] = sum / u[j][j];
            }
        }
        
        fact = YES;
    }
    
    private static void solve(){
        double sum; 
        double []z = new double[10];
        
        z[1] = b[1];
        for(int i = 2; i <= n; i++){
            
            sum = 0.0;
            for(int j = 1; j <= i - 1; j++){
                sum = sum + l[i][j] * z[j];
            }
            
            z[i] = b[i] - sum;
        }
        
        x[n] = z[n] / u[n][n];
        for(int i = n - 1; i >= 1; i--){
            
            sum = 0.0;
            for(int j = i + 1; j <= n; j++){
                sum = sum + u[i][j] * x[j];
            }
            
            x[i] = (z[i] - sum) / u[i][i];
        }
    }
    
}
