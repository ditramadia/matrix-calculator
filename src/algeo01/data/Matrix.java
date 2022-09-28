package algeo01.data;

import java.util.Scanner;

public class Matrix {
    // FIELDS //
    private final int nRow;
    private final int nCol;
    private double[][] tab;

    // CONSTRUCTOR //
    // Create Matrix
    public Matrix(int nRow, int nCol){
        this.nRow = nRow;
        this.nCol = nCol;
        this.tab = new double[nRow][nCol];
        for (int i = 0; i < nRow; i++){
            for (int j = 0; j < nCol; j++){
                this.tab[i][j] = 0;
            }
        }
    }
    // Create Matrix form Augmented Array
    public Matrix(double[][] tab){
        this.nRow = tab.length;
        this.nCol = tab[0].length;
        this.tab = new double[this.nRow][this.nCol];
        for (int i = 0; i < this.nRow; i++){
            for (int j = 0; j < this.nCol; j++){
                this.tab[i][j] = tab[i][j];
            }
        }
    }
    // Copy Matrix
    public Matrix(Matrix M){
        this(M.tab);
    }

    // METHODS //
    // Getter and Setter Methods
    // Get N Rows
    public int getNRow(){
        return this.nRow;
    }
    // Get N Cols
    public int getNCol(){
        return this.nCol;
    }
    // Get Element
    public double getElmt(int i, int j){
        return this.tab[i][j];
    }
    // Set Element
    public void setElmt(int i, int j, double val){
        this.tab[i][j] = val;
    }
    // Get Row
    public double[] getRow(int i){
        return this.tab[i];
    }
    // Set Row
    public void setRow(int rowIdx, double[] row){
        this.tab[rowIdx] = row;
    }

    // Input Output Methods
    // Read Matrix from Console
    public void readMatrix(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < this.nRow; i++){
            for(int j = 0; j < this.nCol; j++){
                this.tab[i][j] = sc.nextInt();;
            }
        }
    }
    // Display Matrix
    public void displayMatrix(){
        for(int i = 0; i < this.nRow; i++){
            for(int j = 0; j < this.nCol; j++){
                System.out.print(this.tab[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    // Arithmetic Operation Methods
    // Add 2 Matrix's
    public Matrix addMatrix(Matrix M){
        Matrix result = new Matrix(this.nRow, this.nCol);
        for(int i = 0; i < this.nRow; i++){
            for(int j = 0; j < this.nCol; j++){
                result.tab[i][j] = getElmt(i, j) + M.getElmt(i, j);
            }
        }
        return result;
    }
    // Subtract 2 Matrix's
    public Matrix subtractMatrix(Matrix M){
        Matrix result = new Matrix(this.nRow, this.nCol);
        for(int i = 0; i < result.nRow; i++){
            for(int j = 0; j < result.nCol; j++){
                result.tab[i][j] = getElmt(i, j) - M.getElmt(i, j);
            }
        }
        return result;
    }
    // Multiply 2 Matrix's
    public Matrix multiplyMatrix(Matrix M){
        if (this.nCol != M.nRow){
            return M;
        }
        Matrix result = new Matrix(this.nRow, M.nCol);
        for(int i = 0; i < result.nRow; i++){
            for(int j = 0; j < result.nCol; j++){
                for(int k = 0; k < M.nRow; k++){
                    result.tab[i][j] += this.tab[i][k] * M.getElmt(k, j);
                }
            }
        }
        return result;
    }
    // Multiply Matrix By A Constant
    public Matrix multiplyByConst(double x){
        Matrix result = new Matrix(this.nRow, this.nCol);
        for(int i = 0; i < result.nRow; i++){
            for(int j = 0; j < result.nCol; j++){
                result.tab[i][j] = this.tab[i][j] * x;
            }
        }
        return result;
    }

    // Relational Operation Methods
    // Is Matrix Size Equal?
    public boolean isMatrixSizeEqual(Matrix M){
        return this.nRow == M.nRow && this.nCol == M.nCol;
    }
    // Is Matrix Equal?
    public boolean isMatrixEqual(Matrix M){
        if (!isMatrixSizeEqual(M)){
            return false;
        }
        for (int i = 0; i < this.nRow; i++){
            for (int j = 0; j < this.nCol; j++){
                if (this.tab[i][j] != M.getElmt(i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    // Test Towards Matrix Methods
    // Is Matrix Square?
    public boolean isSquare(){
        return this.nCol == this.nRow;
    }
    // Is Matrix Identity?
    public boolean isIdentity(){
        if (!isSquare()){
            return false;
        }
        for (int i = 0; i < nRow; i++){
            for (int j = 0; j < nCol; j++){
                if (i == j){
                    if (tab[i][j] != 1){
                        return false;
                    }
                } else {
                    if (tab[i][j] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Transform Methods
    // Transpose
    public Matrix transpose(){
        Matrix result = new Matrix(this.nRow, this.nCol);
        for(int i = 0; i < result.nRow; i++){
            for(int j = 0; j < result.nCol; j++){
                result.setElmt(j, i, getElmt(i, j));
            }
        }
        return result;
    }
    // Swap Rows
    public void swap(int row1, int row2){
        double[] temp = getRow(row1);
        setRow(row1, getRow(row2));
        setRow(row2, temp);
    }
}
