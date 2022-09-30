package algeo01.function;

import algeo01.data.Matrix;

public class RowEchelonResult {
    public static double[] rowEchRes(Matrix M){
        int nVar = M.getNCol() - 1;
        double[] result = new double[nVar];

        // Calculate the last variable
        result[nVar - 1] = M.getElmt(M.getNRow() - 1, M.getNCol() - 1);

        for(int i = 1; i < M.getNRow(); i++){
            result[nVar - i - 1] = M.getElmt(nVar - i - 1, nVar);
            for(int j = 1; j <= i; j++){
                result[nVar - i - 1] -= (M.getElmt(nVar - i - 1, nVar - j) * result[nVar - j]);
            }
        }

        return result;
    }
}
