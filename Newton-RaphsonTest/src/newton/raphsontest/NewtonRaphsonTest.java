
package newton.raphsontest;

import java.util.Scanner;

public class NewtonRaphsonTest {
    
    private static final double E = 0.00001;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the degree: ");
        int degree = input.nextInt();
        double[] equation = new double[degree + 1];
        
        System.out.println("Enter the values: ");
        for(int i = 0; i < equation.length; i++){
            equation[i] = input.nextDouble();
        }
        
        System.out.println("Enter the initial assumption: ");
        double x0 = input.nextDouble();
        
        //double hor = horners(equation, x0);
        //System.out.println("Horners: " + hor);
        
        double[] differentiation = differenciate(equation, degree);
  
//        System.out.println("equation value: " + horners(equation, x0));
//        System.out.println("differentiation value: " + horners(differentiation, x0));
        
        newtonRaphson(equation, differentiation, x0);
        //System.out.println("root is: " + x1);
    }
    
    public static void newtonRaphson(double[] equation, double[] differentiation, double x0){
        double x1;
        while(true){
            if(horners(equation, x0) == 0){
                System.out.println("root is: " + x0);
                break;
            }
            double h = horners(equation, x0) / horners(differentiation, x0);
            //System.out.println(h);
            x1 = x0 - h;
            //System.out.println(x1);
            if(Math.abs((x1 - x0)/ x1) < E){
                System.out.println("Root is: " + x1);
                break;
            }else{
                x0 = x1;
            }
        } 
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
}
