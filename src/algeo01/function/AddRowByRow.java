package algeo01.function;

import algeo01.data.Matrix;

public class AddRowByRow {
    public static void addRowByRow(Matrix M, int row1, double[] row2){
        for (int j = 0; j < M.getNCol(); j++){
            M.setElmt(row1, j, (M.getElmt(row1, j) + row2[j]));
        }
    }
}
