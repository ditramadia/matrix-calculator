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
    // Get Rows
    public int getNRow(){
        return this.nRow;
    }
    // Get Cols
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

    // Arithmetic Operation
    public Matrix addMatrix(Matrix M){
        Matrix result = new Matrix(this.nRow, this.nCol);
        for(int i = 0; i < this.nRow; i++){
            for(int j = 0; j < this.nCol; j++){
                result.tab[i][j] = getElmt(i, j) + M.getElmt(i, j);
            }
        }
        return result;
    }
    public Matrix subtractMatrix(Matrix M){
        Matrix result = new Matrix(this.nRow, this.nCol);
        for(int i = 0; i < result.nRow; i++){
            for(int j = 0; j < result.nCol; j++){
                result.tab[i][j] = getElmt(i, j) - M.getElmt(i, j);
            }
        }
        return result;
    }
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
    public boolean isMatrixSizeEqual(Matrix M){
        return this.nRow == M.nRow && this.nCol == M.nCol;
    }
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

    // Test Field
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);
        Matrix matrix2 = new Matrix(3, 3);
        matrix1.readMatrix();
        matrix2.readMatrix();
        System.out.println(matrix1.isMatrixEqual(matrix2));
    }
}
