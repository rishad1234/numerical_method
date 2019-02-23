
package synthetic_division;

import java.util.Scanner;

public class Synthetic_Division {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of degree: ");
        int degree = input.nextInt();
        int[] equation = new int[degree + 1];
        
        System.out.println("Enter the values: ");
        for(int i = 0; i < equation.length; i++){
            equation[i] = input.nextInt();
        }
        
        printEquation(equation, degree);
        
        System.out.println("Enter a root of the equation: ");
        int root = input.nextInt();
        
        System.out.println("After synthetic division: ");
        int[] newEquation = syntheticDivision(equation, degree, root);
        printEquation(newEquation, degree - 1);
    }
    
    private static void checkForSign(int number){
        if(number < 0){
            System.out.print("+");
        }else{
            System.out.print("");
        }
    }
    
    private static void printEquation(int[] equation, int degree){
        System.out.println("the equation is: ");
        for(int i = 0; i < equation.length; i++){
            if(i == equation.length - 1){
                System.out.print(equation[i]);
            }else{
                System.out.print(equation[i] + "x^" + degree);
                checkForSign(equation[i]);
                degree--;
            }
        }
        System.out.print("=0");
        System.out.println("");
    }
    
    public static int[] syntheticDivision(int[] equation, int degree, int root){
        int[] newEquation = new int[degree];
        
        int temp = 0;
        
        for(int i = 0; i < newEquation.length; i++){
            newEquation[i] = equation[i] + temp * root;
            temp = newEquation[i];
        }
        return newEquation;
    }
}
