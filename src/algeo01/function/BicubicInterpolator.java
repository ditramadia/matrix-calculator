package algeo01.function;

public class BicubicInterpolator extends CubicInterpolator {
    public static double getValue (double[][] p, double x, double y) {
        double[] arr = new double[4];
		for (int i=0; i<4; i++) {
            arr[i] = getValue(p[i], x);
        }
		return getValue(arr, x);
	}

    public static double master(double[][] p, double x, double y) {
        return getValue(p, x, y);
    }
    
}
