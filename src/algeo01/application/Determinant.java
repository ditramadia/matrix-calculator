import java.util.*;
public class Determinant {

	static void getCof(Double matrix[][], Double temp[][],int p, int q, int n)
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
	static Double det(Double matrix[][], int a)
	{
		Double D = 0.0;

		// Base case : matriks 1 element
		if (a == 1)
			return matrix[0][0];

		// nyimpen kofaktor
		Double  temp[][] = new Double[a][a];

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

	/* function for displaying the matrix */
	static void display(Double matrix[][], int row, int col)
	{
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(matrix[i][j]+" ");

			System.out.print("\n");
		}
	}

	// Driver code
	public static void main(String[] args)
	{

		Double matrix[][]
    ;
    int a;
    Scanner input = new Scanner(System.in);
    a=input.nextInt();
    System.out.println("Masukkan nilai matriks");
    matrix = new Double[a][a];
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < a; j++) {
            matrix[i][j] = input.nextDouble();
        }
    }

    System.out.println("Matriks yang diinputkan");
    display(matrix, a, a);

		System.out.print("Determinant "
						+ "of the matrix is : "
						+ det(matrix, a));
	}
}
