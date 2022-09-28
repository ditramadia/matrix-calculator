import algeo01.*;


class invers {
    static Double [][] cofactor (Double matrix [][], int i, int j){
        Double [][] temp = new Double [matrix.length-1][matrix.length-1];
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

    static Double[][] adjoint(Double[][] matrix){
        Double[][] adj = new Double[matrix.length][matrix.length];
        if (matrix.length == 1){
            adj[0][0] = 1.0;
            return adj;
        }
        int sign = 1;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                adj[j][i] = (sign)*(det.determinant(cofactor(matrix, i, j), matrix.length-1));
                sign = -sign;
            }
        }
        return adj;
    }
    static Double [][] inverse(Double [][] matrix){
        Double [][] inv = new Double [matrix.length][matrix.length];
        Double [][] adj = adjoint(matrix);
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix.length; j++){
                inv [i][j] = 1/det.determinant(matrix, matrix.length)*adj[i][j];
            }
        }
        return inv;
    }
}
