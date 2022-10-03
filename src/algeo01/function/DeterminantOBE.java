package algeo01.function;

import algeo01.data.Matrix;

public class DeterminantOBE {
    public static double detOBE(Matrix M){
        double result = 1;

        for (int j = 0; j < M.getNCol(); j++) {
            int sign = 1;
            for (int i = 0; i < M.getNRow(); i++) {
                // Transform diagonal element
                if (i == j) {
                    // Transform diagonal element not equal 0
                    if (M.getElmt(i, j) == 0) {
                        int nonZeroIdx = i + 1;
                        while (M.getElmt(i, j) == 0 && nonZeroIdx < M.getNRow()) {
                            if (M.getElmt(nonZeroIdx, j) != 0 && i != M.getNRow() - 1) {
                                algeo01.function.SwapRows.swap(M, i, nonZeroIdx);
                                sign = -sign;
                                System.out.print("Sign: ");
                                System.out.println(sign);
                            }
                            nonZeroIdx++;
                        }
                    }
                    // Tranforms to 1
                    if (M.getElmt(i, j) != 1 && M.getElmt(i, j) != 0) {
                        double multiplier = 1 / M.getElmt(i, j);
                        algeo01.function.MultplyRowByConst.mulRowByConst(M, i, multiplier);
                        result *= sign * 1 / multiplier;
                        System.out.println("Res: " + result);
                    }
                }

                // Transform non diagonal element
                if (i > j){
                    // Transforms to 0
                    double multiplier = M.getElmt(i, j) > 0 ? M.getElmt(i, j) : -(M.getElmt(i,j));
                    if (M.getElmt(i, j) != 0){
                        if (M.getElmt(i, j) > 0){
                            algeo01.function.SubtractRowByRow.subRowByRow(M, i, algeo01.function.MultplyRowByConst.RetMulRowByConst(M, j, multiplier));
                        } else {
                            algeo01.function.AddRowByRow.addRowByRow(M, i, algeo01.function.MultplyRowByConst.RetMulRowByConst(M, j, multiplier));
                        }
                    }
                }
            }
        }
        return result;
    }
}
