package algeo01.application.SPL.GaussJordan;

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
                System.out.print("Masukkan banyaknya persamaan: ");
                nPers = input.nextInt();
                mPers.setNCol(nPers);
                System.out.println("Masukkan matriks persamaan: ");
                mPers.readMatrix();

                // Input mHasil
                mHasil.setNRow(nPers);
                mHasil.setNCol(1);
                System.out.println("Masukkan matriks hasil: ");
                mHasil.readMatrix();

                // Create m augmented matrix
                m.mergeToRight(mPers, mHasil);
                break;
            case 2:
                // input from file
                System.out.println("Not available yet");
                /*
                FileDialog dialog = new FileDialog((Frame) null, "Pilih sebuah file");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                File[] file = dialog.getFiles();
                m.readMatrix(file[0]);
                */
                break;
        }

        // Gauss Jordan Elimination
        int solutionStatus = algeo01.function.GaussJordanElimination.gaussJordanElimination(m);

        // Output Branches
        if(solutionStatus == 0){
            System.out.println("Program error");
        } else if (solutionStatus == 1) {
            // Display result matrix
            System.out.println("Matrix hasil eliminasi Gauss:");
            m.displayMatrix();
            double[] result = new double[nVar];
            // Display result
            System.out.println("Solusi SPL:");
            result = algeo01.function.RowEchelonResult.rowEchRes(m);
            for(int i = 0; i < result.length; i++){
                System.out.printf("x_" + (i + 1)  + " = %.2f\n", result[i]);
            }
        } else if (solutionStatus == 2) {
            // Display result matrix
            System.out.println("Matrix hasil eliminasi Gauss:");
            m.displayMatrix();
            System.out.println("Solusi banyak/tidak hingga.");
        } else if (solutionStatus == 3) {
            // Display result matrix
            System.out.println("Matrix hasil eliminasi Gauss:");
            m.displayMatrix();
            System.out.println("Solusi tidak ada.");
        }

        algeo01.application.Main.returnToMenu();
    }
}
