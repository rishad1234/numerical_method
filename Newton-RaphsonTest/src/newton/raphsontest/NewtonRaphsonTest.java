
package newton.raphsontest;

import java.util.Scanner;

public class NewtonRaphsonTest {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the degree: ");
        int degree = input.nextInt();
        int[] equation = new int[degree];
        
        System.out.println("enter the values");
        for(int i = 0; i < equation.length; i++){
            equation[i] = input.nextInt();
        }
        
        System.out.println("Enter the initial assumption: ");
        int assumption = input.nextInt();
        
        int hor = horners(equation, assumption);
        System.out.println("Horners: " + hor);
        
        int[] diff = differenciate(equation, degree);
        for(int n : diff){
            System.out.println(n);
        }
        
    }
    
    public static int horners(int[] equation, int inputValue){
        int result = equation[0];
        int length = equation.length;
        for(int i = 1; i < length; i++){
            result = result * inputValue + equation[i];
        }
        return result;
    }
    
    public static int[] differenciate(int[] equation, int degree){
        int length = equation.length;
        int[] diffArray = new int[length - 1];
        
        for(int i = 1; i < length; i++){
            diffArray[i - 1] = equation[i - 1] * --degree;
        }
        return diffArray;
    }
}
