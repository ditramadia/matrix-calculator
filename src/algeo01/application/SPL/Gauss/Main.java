package algeo01.application.SPL.Gauss;

import algeo01.data.Matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Available menus
        final String[] menus = new String[]{
                "Console",
                "Text File",
        };

        // Display menu
        System.out.println("Pilih sumber masukan (input)");
        for (int i = 0; i < menus.length; i++){
            System.out.println((i + 1) + ". " + menus[i]);
        }

        // Asking for user input
        int selectedMenu = 0;
        String strSelectedMenu;
        Scanner input = new Scanner(System.in);

        // Input validation
        boolean isInputInteger = false, isInputAvail = false;
        while (!isInputAvail || !isInputInteger) {
            System.out.print("Pilih masukan: ");
            strSelectedMenu = input.nextLine();
            // Input must be an integer
            try{
                selectedMenu = Integer.parseInt(strSelectedMenu);
                isInputInteger = true;

                // Input must be available
                isInputAvail = (0 < selectedMenu && selectedMenu <= menus.length) ? true : false;
            } catch(NumberFormatException e) {}
            if(!isInputAvail || !isInputInteger){
                System.out.println("Masukan tidak tersedia");
            }
        }

        // Calling Another Application
        int nVar = 0;
        int nPers = 0;
        Matrix mPers = new Matrix();
        Matrix mHasil = new Matrix();
        Matrix m = new Matrix();
        switch (selectedMenu) {
            case 1:
                // Input mPers
                System.out.print("Masukkan banyaknya variabel: ");
                nVar = input.nextInt();
                mPers.setNRow(nVar);
//                m.setNRow(3); // test
                System.out.print("Masukkan banyaknya persamaan: ");
                nPers = input.nextInt();
                mPers.setNCol(nPers);
//                m.setNCol(3); // test
                System.out.println("Masukkan matriks persamaan: ");
                mPers.readMatrix();

                // Input mHasil
                mHasil.setNRow(nPers);
                mHasil.setNCol(1);
                System.out.println("Masukkan matriks hasil: ");
                mHasil.readMatrix();
//                double[] row1 = new double[]{1, 1, 1, 0}; // test
//                double[] row2 = new double[]{2, 3, 1, 1}; // test
//                double[] row3 = new double[]{3, 1, 2, 1}; // test
//                m.setRow(0, row1); // test
//                m.setRow(1, row2); // test
//                m.setRow(2, row3); // test

                // Create m augmented matrix
                m.mergeToRight(mPers, mHasil);
                break;
            case 2:
                 // input from file
                 break;
        }

        // Decides if problem has many solutions
        boolean hasManySolutions = nVar > nPers;

        // Gauss Elimination
        int solutionStatus = algeo01.function.GaussElimination.gaussElimination(m);

        // Output branches
        if(solutionStatus == 0){
            System.out.println("Program error");
        } else if (solutionStatus == 1) {
            double[] solution = new double[m.getNCol() - 1];
            for(int i = 0; i < solution.length; i++){
                solution[solution.length - 1 - i] = m.getElmt(m.getNRow() - 1 - i, m.getNCol() - 1);
            }
            // Display solution
            for(int i = 0; i < solution.length; i++){
                System.out.print(solution[i] + " ");
            }
        } else if (solutionStatus == 2) {
            System.out.println("Solusi banyak/tidak hingga.");
        } else if (solutionStatus == 3) {
            System.out.println("Solusi tidak ada.");
        }
    }
}
