package algeo01.function;

import algeo01.data.Matrix;

public class SubtractRowByRow {
    public static void subRowByRow(Matrix M, int row1, double[] row2){
        for (int j = 0; j < M.getNCol(); j++){
            M.setElmt(row1, j, (M.getElmt(row1, j) - row2[j]));
        }
    }

    public static double[] RetSubRowByRow(Matrix M, int row1, double[] row2){
        double[] result = new double[M.getNCol()];
        for(int j = 0; j < M.getNCol(); j++){
            result[j] = M.getElmt(row1, j) - row2[j];
        }
        return result;
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        m.setNRow(3);
        m.setNCol(4);
        double[] row1 = new double[]{0, 2, 1, 4}; // test
        double[] row2 = new double[]{1, 1, 2, 6}; // test
        double[] row3 = new double[]{2, 1, 1, 7}; // test
        m.setRow(0, row1); // test
        m.setRow(1, row2); // test
        m.setRow(2, row3); // test

        double[] ewe = new double[]{1, 1, 1, 1};
        m.displayMatrix();
        subRowByRow(m, 1, ewe);
        m.displayMatrix();
    }
}
