package algeo01.function;

import algeo01.data.Matrix;

public class MultplyRowByConst {
    public static void mulRowByConst(Matrix M, int i, double val){
        for(int j = 0; j < M.getNCol(); j++){
            M.setElmt(i, j, M.getElmt(i, j) * val);
        }
    }
    public static double[] RetMulRowByConst(Matrix M, int i, double val){
        double[] result = new double[M.getNCol()];
        for(int j = 0; j < M.getNCol(); j++){
            result[j] = M.getElmt(i, j) * val;
        }
        return result;
    }
}
