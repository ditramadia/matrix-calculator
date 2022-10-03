package algeo01.function;

import algeo01.data.Matrix;

public class InverseOBE {
    public static void inverseOBE(Matrix M){
        int nCol = M.getNCol()/2;

        for (int j = 0; j < nCol; j++) {
            // Pre-read to get main 1
            for (int i = 0; i < M.getNRow(); i++) {
                // Transform diagonal element
                if (i == j) {
                    // Transform diagonal element not equal 0
                    if (M.getElmt(i, j) == 0) {
                        int nonZeroIdx = i + 1;
                        while (M.getElmt(i, j) == 0 && nonZeroIdx < M.getNRow()) {
                            if (M.getElmt(nonZeroIdx, j) != 0 && i != M.getNRow() - 1) {
                                algeo01.function.SwapRows.swap(M, i, nonZeroIdx);
                            }
                            nonZeroIdx++;
                        }
                    }
                    // Tranforms to 1
                    if (M.getElmt(i, j) != 1 && M.getElmt(i, j) != 0) {
                        double multiplier = 1 / M.getElmt(i, j);
                        algeo01.function.MultplyRowByConst.mulRowByConst(M, i, multiplier);
                    }
                }


            }

            // Read to get non diagonal equals 0
            for (int i = 0; i < M.getNRow(); i++) {
                // Transform non diagonal element
                if (i != j) {
                    // Transforms to 0
                    double multiplier = M.getElmt(i, j) > 0 ? M.getElmt(i, j) : -(M.getElmt(i, j));
                    if (M.getElmt(i, j) != 0) {
                        if (M.getElmt(i, j) > 0) {
                            algeo01.function.SubtractRowByRow.subRowByRow(M, i, algeo01.function.MultplyRowByConst.RetMulRowByConst(M, j, multiplier));
                        } else {
                            algeo01.function.AddRowByRow.addRowByRow(M, i, algeo01.function.MultplyRowByConst.RetMulRowByConst(M, j, multiplier));
                        }
                    }
                }
            }
        }
    }
}
