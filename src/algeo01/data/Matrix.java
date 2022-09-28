package algeo01.data;

public class Matrix {
    // FIELDS //
    private final int nRow;
    private final int nCol;
    private final double[][] tab;

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

    // Input Output Methods
    // Read Matrix from Console
    
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

}
