package hornersmethod;
import java.util.Scanner;

public class HornersMethod {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the degree: ");
        int degree = input.nextInt();
        int[] equation = new int[degree + 1];
        
        System.out.println("enter the values");
        for(int i = 0; i < equation.length; i++){
            equation[i] = input.nextInt();
        }
        
        System.out.println("Enter the initial assumption: ");
        int assumption = input.nextInt();
        
        int hor = horners(equation, assumption);
        System.out.println("Horners: " + hor);
                
    }
    
    public static int horners(int[] equation, int inputValue){
        int result = equation[0];
        int length = equation.length;
        for(int i = 1; i < length; i++){
            result = result * inputValue + equation[i];
        }
        return result;
    }
}
