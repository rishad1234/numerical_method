
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
    
    public static int horners(int[] equation, int inputValue){
        
        int result = equation[0];
        int length = equation.length;
        for(int i = 1; i < length; i++){
            result = result * inputValue + equation[i];
        }
        return result;
    }
    
    public static void modifiedBisection(double[] equation, double lower, double upper){
        
    }
}
