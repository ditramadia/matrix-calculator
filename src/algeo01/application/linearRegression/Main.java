package algeo01.application.linearRegression;

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
        System.out.println("MENU REGRESI LINEAR BERGANDA");
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
        int nVar = 0, nSample = 0;
        Matrix m = new Matrix();
        double[] x_k = new double[]{0, 0, 0};
        switch (selectedMenu) {
            case 1:
                // input nVar
                System.out.print("Masukkan banyaknya variabel: ");
                nVar = input.nextInt();
                m.setNCol(nVar + 1);

                // input nSample
                System.out.print("Masukkan banyaknya sampel: ");
                nSample = input.nextInt();
                m.setNRow(nSample);

                // input points
                System.out.println("Masukkan sampel: ");
                m.readMatrix();

                // input x_k
                System.out.println("Masukkan x yang dicari");
                x_k = new double[nVar];
                for(int i = 0; i < x_k.length; i++){
                    x_k[i] = input.nextDouble();
                }

                break;
            case 2:
                System.out.println("Not available yet");
                algeo01.application.linearRegression.Main.main(null);
                break;
        }

        // Normal Estimation Equation
        Matrix equation = algeo01.function.NormalEstimation.normalEstEq(m);

        // Gauss Elimination
        int solutionStatus = algeo01.function.GaussElimination.gaussElimination(equation);

        // Output Branches
        if(solutionStatus == 0){
            System.out.println("Program error");
        } else if (solutionStatus == 1) {
            // Display result
            double[] result = new double[nVar];
            System.out.println("Solusi SPL:");
            result = algeo01.function.RowEchelonResult.rowEchRes(equation);
            double y = result[0];
            for(int i = 0; i < nVar; i++){
                y += result[i + 1] * x_k[i];
            }
            System.out.printf("%.5f\n", y);
        } else if (solutionStatus == 2) {
            // Display result matrix
            System.out.println("Matrix hasil eliminasi Gauss:");
            equation.displayMatrix();
            System.out.println("Solusi banyak/tidak hingga.");
        } else if (solutionStatus == 3) {
            // Display result matrix
            System.out.println("Matrix hasil eliminasi Gauss:");
            equation.displayMatrix();
            System.out.println("Solusi tidak ada.");
        }

        algeo01.application.Main.returnToMenu();
    }
}
