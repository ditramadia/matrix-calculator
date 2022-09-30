package algeo01.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {
    // FIELDS //
    private int nRow = 0;
    private int nCol = 0;
    private double[][] tab;

    // CONSTRUCTOR //
    // Create Matrix with nRow and nCol
    public Matrix(int nRow, int nCol) {
        this.nRow = nRow;
        this.nCol = nCol;
        this.tab = new double[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                this.tab[i][j] = -999;
            }
        }
    }

    // Create Matrix from Augmented Array
    public Matrix(double[][] tab) {
        this.nRow = tab.length;
        this.nCol = tab[0].length;
        this.tab = new double[this.nRow][this.nCol];
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.tab[i][j] = tab[i][j];
            }
        }
    }

    // Copy Matrix
    public Matrix(Matrix M) {
        this(M.tab);
    }

    // Create Matrix
    public Matrix() {
        this.tab = new double[50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                this.tab[i][j] = -999;
            }
        }
    }

    // METHODS //
    // Getter and Setter Methods
    // Get N Rows
    public int getNRow() {
        return this.nRow;
    }

    // Set N Rows
    public void setNRow(int nRow) {
        this.nRow = nRow;
    }

    // Get N Cols
    public int getNCol() {
        return this.nCol;
    }

    // Set N Cols
    public void setNCol(int nCol) {
        this.nCol = nCol;
    }

    // Get Element
    public double getElmt(int i, int j) {
        return this.tab[i][j];
    }

    // Set Element
    public void setElmt(int i, int j, double val) {
        this.tab[i][j] = val;
    }

    // Get Row
    public double[] getRow(int i) {
        return this.tab[i];
    }

    // Set Row
    public void setRow(int rowIdx, double[] row) {
        this.tab[rowIdx] = row;
    }

    // Input Output Methods
    // Read Matrix from File
    public void readMatrix(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        nRow = 0;
        nCol = 0;
        // Pre-read
        while (sc.hasNextLine()){
            nRow++;
            Scanner colReader = new Scanner(sc.nextLine());
            while(colReader.hasNextInt()){
                nCol++;
            }
        }
        sc.close();

        // Read the data
        sc = new Scanner(file);
        for(int i = 0; i < nRow; i++){
            for(int j = 0; j < nCol; j++){
                if(sc.hasNextInt()){
                    tab[i][j] = sc.nextInt();
                }
            }
        }
    }

    // Read Matrix from Console
    public void readMatrix() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                this.tab[i][j] = sc.nextInt();
                ;
            }
        }

        if (nRow == 0 && nCol == 0) {
            while (tab[nRow][0] != -999) {
                nRow++;
            }
            while (tab[0][nCol] != -999) {
                nCol++;
            }
        }
    }

    // Display Matrix
    public void displayMatrix() {
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                System.out.printf("%.2f", this.tab[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    // Arithmetic Operation Methods
    // Add 2 Matrix's
    public Matrix addMatrix(Matrix M) {
        Matrix result = new Matrix(this.nRow, this.nCol);
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                result.tab[i][j] = getElmt(i, j) + M.getElmt(i, j);
            }
        }
        return result;
    }

    // Subtract 2 Matrix's
    public Matrix subtractMatrix(Matrix M) {
        Matrix result = new Matrix(this.nRow, this.nCol);
        for (int i = 0; i < result.nRow; i++) {
            for (int j = 0; j < result.nCol; j++) {
                result.tab[i][j] = getElmt(i, j) - M.getElmt(i, j);
            }
        }
        return result;
    }

    // Multiply 2 Matrix's
    public Matrix multiplyMatrix(Matrix M) {
        if (this.nCol != M.nRow) {
            return M;
        }
        Matrix result = new Matrix(this.nRow, M.nCol);
        for (int i = 0; i < result.nRow; i++) {
            for (int j = 0; j < result.nCol; j++) {
                for (int k = 0; k < M.nRow; k++) {
                    result.tab[i][j] += this.tab[i][k] * M.getElmt(k, j);
                }
            }
        }
        return result;
    }

    // Multiply Matrix By A Constant
    public Matrix multiplyByConst(double x) {
        Matrix result = new Matrix(this.nRow, this.nCol);
        for (int i = 0; i < result.nRow; i++) {
            for (int j = 0; j < result.nCol; j++) {
                result.tab[i][j] = this.tab[i][j] * x;
            }
        }
        return result;
    }

    // Relational Operation Methods
    // Is Matrix Size Equal?
    public boolean isMatrixSizeEqual(Matrix M) {
        return this.nRow == M.nRow && this.nCol == M.nCol;
    }

    // Is Matrix Equal?
    public boolean isMatrixEqual(Matrix M) {
        if (!isMatrixSizeEqual(M)) {
            return false;
        }
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                if (this.tab[i][j] != M.getElmt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Test Towards Matrix Methods
    // Is Matrix Square?
    public boolean isSquare() {
        return this.nCol == this.nRow;
    }

    // Is Matrix Identity?
    public boolean isIdentity() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (i == j) {
                    if (tab[i][j] != 1) {
                        return false;
                    }
                } else {
                    if (tab[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Transform Methods
    // Transpose
    public Matrix transpose() {
        Matrix result = new Matrix(this.nRow, this.nCol);
        for (int i = 0; i < result.nRow; i++) {
            for (int j = 0; j < result.nCol; j++) {
                result.setElmt(j, i, getElmt(i, j));
            }
        }
        return result;
    }

    // Merge Matrix Methods
    // Merge matrix to the right
    public void mergeToRight(Matrix M1, Matrix M2) {
        // Matrix result = new Matrix(M1.getNRow(), M1.getNCol() + M2.getNCol());
        this.setNRow(M1.getNRow());
        this.setNCol(M1.getNCol() + M2.getNCol());
        for (int i = 0; i < M1.getNRow(); i++) {
            for (int j = 0; j < this.getNCol(); j++) {
                this.setElmt(i, j, M1.getElmt(i, j));
            }
        }
        for (int i = 0; i < M2.getNRow(); i++) {
            for (int j = 0; j < M2.getNCol(); j++) {
                this.setElmt(i, M1.getNCol() + j, M2.getElmt(i, j));
            }
        }
    }
}
