package algeo01.function;

import algeo01.data.Matrix;

public class NormalEstimation {
    public static double colSum(Matrix m, int j){
        double sum = 0;
        for(int i = 0; i < m.getNRow(); i++){
            sum += m.getElmt(i, j);
        }
        return sum;
    }

    public static double twoColSum(Matrix m, int j1, int j2){
        double sum = 0;
        for(int i = 0; i < m.getNRow(); i++){
            sum += m.getElmt(i, j1) * m.getElmt(i, j2);
        }
        return sum;
    }

    public static Matrix normalEstEq(Matrix data){
        double[][] tab = new double[data.getNCol()][data.getNCol() + 1];
        Matrix result = new Matrix(data.getNCol(), data.getNCol() + 1);
        result.setTab(tab);

        for(int i = 0; i < result.getNRow(); i++){
            for(int j = 0; j < result.getNCol(); j++){
                if(i == 0){
                    if(j == 0){
                        result.setElmt(i, j, data.getNRow());
                    }else{
                        result.setElmt(i, j, colSum(data, j - 1));
                    }
                }else{
                    if(j == 0){
                        result.setElmt(i, j, colSum(data, i - 1));
                    }else{
                        result.setElmt(i, j, twoColSum(data, i - 1, j - 1));
                    }
                }
            }
        }
        return result;
    }
}
