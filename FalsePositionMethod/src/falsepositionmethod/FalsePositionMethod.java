
package falsepositionmethod;

import java.util.Scanner;

public class FalsePositionMethod {
    public static final double E = 0.001;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        
        double x1, x2;
        System.out.println("Enter the values of x1 and x2: ");
        x1 = input.nextDouble();
        x2 = input.nextDouble();
        
        if((evaluateFunc(x1) * evaluateFunc(x2)) > 0){
            System.out.println("assumption is wrong");
        }else{
            System.out.println("assumption is right");
            while(Math.abs((x2 - x1)/ x2) > E){
                double x0 = calculateX0(x1, x2);
                double f0 = evaluateFunc(x0);
                if(f0 == 0){
                    System.out.println("root is: " + x0);
                    break;
                }else if((evaluateFunc(x1) * evaluateFunc(x0)) < 0){
                    x2 = x0;
                }else{
                    x1 = x0;
                }    
            }
            //System.out.println("root is: " + ((x2 + x1)/2));
        }
    }
    
    private static double calculateX0(double x1, double x2){
        double temp = evaluateFunc(x1) * (x2 - x1);
        double temp2 = evaluateFunc(x2) - evaluateFunc(x1);
        
        return (x1 - (temp / temp2));
    }
    
    private static double evaluateFunc(double x){
        return ((x * x * x) + (3 * x) - 5);
    }
    
}
