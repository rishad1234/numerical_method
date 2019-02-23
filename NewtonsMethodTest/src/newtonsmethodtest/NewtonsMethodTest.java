
package newtonsmethodtest;

import java.util.Scanner;

public class NewtonsMethodTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of degree: ");
        int degree = input.nextInt();
        double[] equation = new double[degree];
        
        System.out.println("Enter the equation: ");
        for(int i = 0; i < equation.length; i++){
            equation[i] = input.nextDouble();
        }
        
    }
    
    private static void checkForSign(double number){
        if(number < 0){
            System.out.print("+");
        }else{
            System.out.print("");
        }
    }
    
    private static void printEquation(double[] equation, int degree){
        System.out.println("the equation is: ");
        int temp = degree - 1;
        for(int i = 0; i < equation.length; i++){
            if(i == equation.length - 1){
                System.out.print(equation[i]);
            }else{
                System.out.print(equation[i] + "x^" + temp);
                checkForSign(equation[i]);
                temp--;
            }
        }
        System.out.print("=0");
        System.out.println("");
    }
    
    public static double[] syntheticDivision(double[] equation, int degree,double root){
        double[] newEquation = new double[degree - 1];
        
        double temp = 0;
        
        for(int i = 0; i < newEquation.length; i++){
            newEquation[i] = equation[i] + temp * root;
            temp = newEquation[i];
        }
        return newEquation;
    }
    
    public static double horners(double[] equation, double inputValue){
        double result = equation[0];
        int length = equation.length;
        for(int i = 1; i < length; i++){
            result = result * inputValue + equation[i];
        }
        return result;
    }
    
    public static double[] differenciate(double[] equation, int degree){
        int length = equation.length;
        double[] diffArray = new double[length - 1];
        
        for(int i = 1; i < length; i++){
            diffArray[i - 1] = equation[i - 1] * --degree;
        }
        return diffArray;
    }
    
    public static void newtonsMethod(int[] equation, double iniatiaValue){
        
    }
    
}
