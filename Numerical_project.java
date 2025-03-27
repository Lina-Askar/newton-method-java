package numerical_project;

public class NumericalProject {

    public static void main(String[] args) {

        double p0 = Math.PI / 4; // initial approximation
        double TOL = 0.00000001; // 10^-8 tolerance
        int N0 = 100; // max number of iterations
        int i = 1; // iteration counter
        double p = p0; // current approximation
        double initial = p0;

        double[] iterations = new double[N0]; // store each approximation

        while (i <= N0) {
            p = p0 - (f(p0) / fPrime(p0)); // Newton-Raphson formula
            iterations[i - 1] = p;

            if (Math.abs(p - p0) < TOL) {
                System.out.println("  n      Pn");
                System.out.println("-----------------------");
                System.out.println("P0: " + initial);
                for (int j = 0; j < i; j++) {
                    System.out.println("P" + (j + 1) + ": " + iterations[j]);
                }
                return;
            }

            i++;
            p0 = p;
        }

        System.out.println("The method failed after " + N0 + " iterations.");
        System.out.println("The procedure was unsuccessful.");
    }

    // f(x) = cos(x) - x
    public static double f(double x) {
        return Math.cos(x) - x;
    }

    // f'(x) = -sin(x) - 1
    public static double fPrime(double x) {
        return -Math.sin(x) - 1;
    }
}
