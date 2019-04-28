
package secantmethod;

import java.util.Scanner;

public class SecantMethod {

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
        
        System.out.println("Enter the 1st assumption: ");
        double x1 = input.nextDouble();
        
        System.out.println("Enter the second assumption: ");
        double x2 = input.nextDouble();
        
        double f1 = horners(equation, x1);
        double f2 = horners(equation, x2);
        
        while(true){
            double x3 = (f2 * x1 - f1 * x2) / (f2 - f1);
            System.out.println(x1 + "\t\t\t" + x2 + "\t\t\t" + x3 + "\t\t\t" + f1 + "\t\t\t" + f2);
                    
            if(Math.abs((x3 - x2)/ x3) > E){
                System.out.println(Math.abs((x3 - x2)/ x3));
                x1 = x2;
                f1 = f2;
                x2 = x3;
                f2 = horners(equation, x3);
                System.out.println(f2);
            }else{
                System.out.println(Math.abs((x3 - x2)/ x3));
                System.out.println("Root is: " + x3);
                break;
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
}
