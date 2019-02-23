
package synthetic_division;

import java.util.Scanner;

public class Synthetic_Division {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of degree: ");
        int degree = input.nextInt();
        int[] equation = new int[degree];
        
        System.out.println("Enter the values: ");
        for(int i = equation.length - 1; i >= 0; i--){
            equation[i] = input.nextInt();
        }
        
        System.out.println("the equation is: ");
        for(int i = equation.length - 1; i >= 0; i--){
            if(i == 0){
                System.out.print(equation[i]);
            }else{
                System.out.print(equation[i] + "x^" + i);
                checkForSign(equation[i]);
            }
        }
        System.out.print("=0");
        System.out.println("");
    }
    
    private static void checkForSign(int number){
        if(number < 0){
            System.out.print("+");
        }else{
            System.out.print("");
        }
    }
    
}
