
package newtonsmethodtest;

import java.util.Scanner;

public class NewtonsMethodTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of degree: ");
        int degree = input.nextInt();
        double[] equation = new double[degree + 1];
        
        System.out.println("Enter the equation: ");
        for(int i = 0; i < equation.length; i++){
            equation[i] = input.nextDouble();
        }
        
        System.out.println("Enter the initial guess: ");
        double x0 = input.nextDouble();
        newtonsMethod(equation, x0, degree);
        
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
    
    public static double[] syntheticDivision(double[] equation, int degree, double root){
        double[] newEquation = new double[degree];
        
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
        
        for(int i = 0; i < length - 1; i++){
            diffArray[i] = equation[i] * degree;
            degree--;
        }
        return diffArray;
    }
    
    public static double newtonRaphson(double[] equation, double[] diffArray, double x0){
        double x1 = 0.0;
        int i = 0;
        double f0;
        System.out.println("Iteration\t\tx0\t\t\tx1\t\t\tf(x0)\n");
        while(true){
            f0 = horners(equation, x0);
            if(horners(equation, x0) == 0){
                System.out.println("root is: " + x0);
                break;
            }
            double h = horners(equation, x0) / horners(diffArray, x0);
            x1 = x0 - h;
            System.out.format("%d\t\t\t%f\t\t%f\t\t%f\n",++i,x0,x1,f0);
            if(Math.abs((x1 - x0)/ x1) < 0.00001){
                System.out.println("Root is: " + x1);
                break;
            }else{
                x0 = x1;
            }
        }
        return x1;
    }
    
    public static void newtonsMethod(double[] equation, double x0, int degree){
        
        double[] temp = equation;
        //System.out.println(temp.length);
        double[] tempDiff = differenciate(equation, degree);
        //System.out.println(tempDiff.length);
        double x1;
        while(degree > 1){
            x1 = newtonRaphson(temp, tempDiff, x0);
            x0 = x1;
            temp = syntheticDivision(temp, degree, x1);
            tempDiff = differenciate(temp, degree);
            degree--;
        }
        System.out.println("Root is: " + -temp[1] / temp[0]);
    }   
}
