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

    // Test Field
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);
        matrix1.readMatrix();
        matrix1.displayMatrix();
    }
}
