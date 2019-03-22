
package polynomialregression;

public class PolynomialRegression {
    
    public static double[][] coefficients = new double[10][10];
    public static double[] rightSideVector = new double[10];
    public static double[] resultVector = new double[10];
    public static void main(String[] args) {
        
    }
    
    public static void gauss(int size){
        double pivot, factor, sum;
        for(int k = 1; k <= size - 1; k++){
            pivot = coefficients[k][k];
            for(int i = k + 1; i <= size; i++){
                factor = coefficients[i][k] / pivot;
                for(int j = k + 1; j <= size; j++){
                    coefficients[i][j] = coefficients[i][j] - factor * coefficients[k][j];
                }
                rightSideVector[i] = rightSideVector[i] - factor * rightSideVector[k];
            }
        }
        
        resultVector[size] = rightSideVector[size] / coefficients[size][size];
        for(int k = size - 1; k >= 1; k--){
            sum = 0.0;
            for(int j = k + 1; j <= size; j++){
                sum = sum + coefficients[k][j] * resultVector[j];
            }
            resultVector[k] = (rightSideVector[k] - sum) / coefficients[k][k];
        }
    }
}
