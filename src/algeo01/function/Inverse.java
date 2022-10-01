package algeo01.function;


import algeo01.data.Matrix;

public class Inverse {
    /*static double[][] cofactor(double matrix[][], int i, int j) {
        double[][] temp = new double[matrix.length - 1][matrix.length - 1];
        int x = 0;
        int y = 0;
        for (int k = 0; k < matrix.length; k++) {
            for (int l = 0; l < matrix.length; l++) {
                if (k != i && l != j) {
                    temp[x][y] = matrix[k][l];
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
    */
    static public double[][] getCof(double matrix[][],int p, int q, int n)
	{
        double temp[][] = new double[n][n];
		int i = 0, j = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (row != p && col != q) {
					temp[i][j++] = matrix[row][col];
					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
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
                adj[j][i] = (sign) * (Determinant.det(getCof(matrix, i, j, matrix.length ), matrix.length - 1));
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

    public static Matrix inversem(Matrix matrix) {
        Matrix inverse = new Matrix(matrix.getNRow(), matrix.getNCol());
        double[][] inv = inv(matrix.getTab());
        inverse.setTab(inv);
        return inverse;
    }

    public static Matrix master(Matrix matrix) {
        // initialize matrix
        Matrix m = new Matrix(matrix.getNRow(), matrix.getNCol());
        for (int i=0; i<matrix.getNRow(); i++) {
            for (int j=0; j<matrix.getNCol(); j++) {
                m.setElmt(i, j, matrix.getElmt(i, j));
            }
        }

        // initialize result
        Matrix mRes = new Matrix(3, 3);

        // Inverse
        mRes=inversem(m);

        System.out.println("============");
        mRes.displayMatrix();
        return mRes;


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

    public static void main (String[] args) {
        Matrix p=new Matrix(3,3);
        p.setElmt(0,0,1);
        p.setElmt(0,1,1);
        p.setElmt(0,2,1);
        p.setElmt(1,0,2);
        p.setElmt(1,1,3);
        p.setElmt(1,2,1);
        p.setElmt(2,0,3);
        p.setElmt(2,1,1);
        p.setElmt(2,2,2);
        master(p);

    }
}
