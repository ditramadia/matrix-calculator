package algeo01.function;

import algeo01.data.Matrix;

public class SwapRows {
    public static void swap(Matrix M, int row1, int row2){
        double[] temp = M.getRow(row1);
        M.setRow(row1, M.getRow(row2));
        M.setRow(row2, temp);
    }
}
