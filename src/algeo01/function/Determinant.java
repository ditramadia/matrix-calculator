package algeo01.function;

import algeo01.data.Matrix;

import java.util.*;

public class Determinant {

	static public void getCof(double matrix[][], double temp[][],int p, int q, int n)
	{
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
	}
	static public double det(double matrix[][], int a)
	{
		Double D = 0.0;

		// Base case : matriks 1 element
		if (a == 1)
			return matrix[0][0];

		// nyimpen kofaktor
		double  temp[][] = new double[a][a];

		int s = 1;
        // s= sign 1/-1

		for (int i = 0; i < a; i++) {
			// Getting Cofactor of matrix[0][i]
			getCof(matrix, temp, 0, i, a);
			D += s * matrix[0][i] * det(temp, a - 1);

			s = -s;
		}

		return D;
	}
}
