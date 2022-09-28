package algeo01.application;

import algeo01.data.Matrix;

public class TestField {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);
        Matrix matrix2 = new Matrix(3, 3);
        Matrix matrix3 = new Matrix(3, 3);
        matrix1.readMatrix();
        matrix2.readMatrix();
        matrix3 = matrix1.addMatrix(matrix2);
        matrix3.displayMatrix();
    }
}
