
package modifiedbisectiontest;

import java.util.Scanner;

public class ModifiedBisectionTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the degree: ");
        int degree = input.nextInt();
        
        System.out.println("Enter the value of the coefficients: ");
        double[] equation = new double[degree + 1];
        
        for(int i = 0; i < equation.length; i++){
            equation[i] = input.nextDouble();
        }
        
        System.out.println("Enter the lower limit: ");
        double lowerLimit = input.nextDouble();
        System.out.println("Enter the upper limit: ");
        double upperLimit = input.nextDouble();
        
        modifiedBisection(equation, lowerLimit, upperLimit); 
    }
    
    public static double horners(double[] equation, double inputValue){
        
        double result = equation[0];
        int length = equation.length;
        for(int i = 1; i < length; i++){
            result = result * inputValue + equation[i];
        }
        return result;
    }
    
    public static void modifiedBisection(double[] equation, double lower, double upper){
        double dx = 0.00001;
        double E = 0.000000001;
        double x0, x1, x2;
        double f0, f1, f2;
        x2 = lower;
        
        while(x2 < upper){
            lower = x2;
            x1 = lower;
            x2 = x1 + dx;
            f1 = horners(equation, x1);
            f2 = horners(equation, x2);
            while(Math.abs((x2 - x1) / x2) > E){
                if(f1 * f2 > 0){
                    break;
                }
                x0 = (x1 + x2) / 2.0;
                f0 = horners(equation, x0);
                if(f0 == 0){
                    //x2 = x1 = x0;
                }else if(f1 * f0 < 0){
                    x2 = x0;
                    f2 = f0;
                }else{
                    x1 = x0;
                    f1 = f0;
                }
                System.out.println(x0 + " " + x1 + " " + x2);
            }
            
            if(Math.abs((x2 - x1) / x2) < E){
                System.out.println("root is: " + (x1 + x2)/ 2.0);
            }
        }
    }
}
