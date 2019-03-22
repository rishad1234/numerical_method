
package linearregression;

import java.util.Scanner;

public class LinearRegression {

    public static double x[] = new double[100000];
    public static double y[] = new double[100000];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int points = input.nextInt();
        System.out.println("Enter the values of x and y with a space between them one bty one: ");
        for(int i = 0; i < points; i++){
            x[i] = input.nextDouble();
            y[i] = input.nextDouble();
        }

        double sumX = 0.0, sumY = 0.0, sumX2 = 0.0, sumXY = 0.0, xMean = 0.0, yMean = 0.0;
        
        for(int i = 0; i < points; i++){
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumXY += x[i] * y[i];
        }
        
        xMean = sumX / points;
        yMean = sumY / points;
        
        double denom = (points * sumX2) - (sumX * sumX);
        if(denom != 0){
            double b = (points * sumXY - sumX * sumY) / denom;
            double a = yMean - b * xMean;
            
            System.out.println("The equation is: ");
            System.out.println("Y = " + a + " + " + b + "X");
        }
    }
}
