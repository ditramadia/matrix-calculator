package algeo01.function;


import algeo01.data.Matrix;

public class Inverse {
    static double [][] cofactor (double matrix [][], int i, int j){
        double [][] temp = new double [matrix.length-1][matrix.length-1];
        int x = 0;
        int y = 0;
        for (int a = 0; a < matrix.length; a++){
            for (int b = 0; b < matrix.length; b++){
                if (a != i && b != j){
                    temp[x][y] = matrix[a][b];
                    y++;
                    if (y == matrix.length-1){
                        y = 0;
                        x++;
                    }
                }
            }
        }

        return temp;
    }

    static double[][] adjoint(double[][] matrix){
        double[][] adj = new double[matrix.length][matrix.length];
        if (matrix.length == 1){
            adj[0][0] = 1.0;
            return adj;
        }
        int sign = 1;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                adj[j][i] = (sign)*(Determinant.det(cofactor(matrix, i, j), matrix.length-1));
                sign = -sign;
            }
        }
        return adj;
    }
    public static double [][] inv(double [][] matrix){
        double [][] inv = new double [matrix.length][matrix.length];
        double [][] adj = adjoint(matrix);
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix.length; j++){
                inv [i][j] = 1/Determinant.det(matrix, matrix.length)*adj[i][j];
            }
        }
        return inv;
    }

    public static void main(String[] args) {
        // initialize matrix
        Matrix m = new Matrix(2,2);
        m.setElmt(0, 0, 4);
        m.setElmt(0, 1, 3);
        m.setElmt(1, 0, 3);
        m.setElmt(1, 1, 2);
        m.displayMatrix();

        // initialize result
        Matrix mRes = new Matrix(2,2);
        System.out.println("============");

        // inverse
        mRes.setTab(inv(m.getTab()));
        mRes.displayMatrix();

        // Dit, ini masih salah, cobain geura
    }
}
