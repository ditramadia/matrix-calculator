package algeo01.function;


import algeo01.data.Matrix;

public class Inverse {
    static double[][] cofactor(double matrix[][], int i, int j) {
        double[][] temp = new double[matrix.length - 1][matrix.length - 1];
        int x = 0;
        int y = 0;
        for (int a = 0; a < matrix.length; a++) {
            for (int b = 0; b < matrix.length; b++) {
                if (a != i && b != j) {
                    temp[x][y] = matrix[a][b];
                    y++;
                    if (y == matrix.length - 1) {
                        y = 0;
                        x++;
                    }
                }
                System.out.println("loop");
            }
        }

        return temp;
    }

    static double[][] adjoint(double[][] matrix) {
        double[][] adj = new double[matrix.length][matrix.length];
        if (matrix.length == 1) {
            adj[0][0] = 1.0;
            return adj;
        }
        int sign = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                adj[j][i] = (sign) * (Determinant.det(cofactor(matrix, i, j), matrix.length - 1));
                sign = -sign;
            }
        }
        return adj;
    }

    public static double[][] inv(double[][] matrix) {
        double[][] inv = new double[matrix.length][matrix.length];

        if (matrix.length == 2) {
            inv = inv2(matrix);

            return inv;
        }

        double[][] adj = adjoint(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                inv[i][j] = 1 / Determinant.det(matrix, matrix.length) * adj[i][j];
            }
        }
        return inv;
    }

    public static double[][] inv2(double[][] matrix) {
        double[][] inv = new double[matrix.length][matrix.length];
        double[][] temp;
        temp = matrix;
        inv[0][0] = temp[1][1] / Determinant.det(matrix, matrix.length);
        inv[0][1] = -temp[0][1] / Determinant.det(matrix, matrix.length);
        inv[1][0] = -temp[1][0] / Determinant.det(matrix, matrix.length);
        inv[1][1] = temp[0][0] / Determinant.det(matrix, matrix.length);
        return inv;
    }

    public static void main(String[] args) {
        // initialize matrix
        Matrix m = new Matrix(3, 3);
        m.setElmt(0, 0, 1);
        m.setElmt(0, 1, 2);
        m.setElmt(0, 2, 1);
        m.setElmt(1, 0, 2);
        m.setElmt(1, 1, 3);
        m.setElmt(1, 2, 4);
        m.setElmt(2, 0, 1);
        m.setElmt(2, 1, 2);
        m.setElmt(2, 2, 3);
        m.displayMatrix();

        // initialize result
        Matrix mRes = new Matrix(3, 3);

        // Inverse
        mRes.setTab(inv(m.getTab()));

        System.out.println("============");
        mRes.displayMatrix();


        // inverse
        /* 
        if (m.getNRow() ==2){
        mRes.setTab(inv2(m.getTab()));
        mRes.displayMatrix();}
        else{
            mRes.setTab(inv(m.getTab()));
            mRes.displayMatrix();
        }
        */

        // Dit, ini masih salah, cobain geura
    }
}
