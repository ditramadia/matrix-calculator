package algeo01.function;

import algeo01.data.Matrix;

public class GaussJordanElimination {
    public static int gaussJordanElimination(Matrix M){
        for (int i = 0; i < M.getNCol() - 1; i++) {
            for (int j = 0; j < M.getNRow(); j++) {
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
                } else {
                    // Transforms to 0
                    double multiplier = M.getElmt(i, j) > 0 ? M.getElmt(i, j) : -(M.getElmt(i, j));
                    if(M.getElmt(i, j) != 0){
                        if(M.getElmt(i, j) > 0){

                        }
                    }
                }
            }
        }

        // Decides if problem has many solutions
        boolean hasManySolutions = false;
        if (M.getElmt(M.getNRow() - 1, M.getNCol() - 1) == 0){
            hasManySolutions = true;
            for(int j = 0; j < M.getNCol() - 1; j++){
                if (M.getElmt(M.getNRow() - 1, j) != 0){
                    hasManySolutions = false;
                }
            }
        }

        // Decides if problem has solution
        boolean hasNoSolution = false;
        if (M.getElmt(M.getNRow() - 1, M.getNCol() - 1) != 0){
            hasNoSolution = true;
            for(int j = 0; j < M.getNCol() - 1; j++){
                if (M.getElmt(M.getNRow() - 1, j) != 0){
                    hasNoSolution = false;
                }
            }
        }

        if(!hasManySolutions && !hasNoSolution){
            // Has unique solution
            return 1;
        } else if (hasManySolutions){
            // Has many solution
            return 2;
        } else if (hasNoSolution){
            // has no solution
            return 3;
        }
        // Error
        return 0;
    }
}
