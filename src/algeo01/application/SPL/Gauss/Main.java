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
        Matrix m = new Matrix();
        switch (selectedMenu) {
            case 1:
                // System.out.print("Masukkan banyak baris matriks: ");
                // m.setNRow(input.nextInt());
                m.setNRow(3); // test
                // System.out.print("Masukkan banyak kolom matriks: ");
                // m.setNCol(input.nextInt());
                m.setNCol(4); // test
                // m.readMatrix();
                double[] row1 = new double[]{0, 2, 1, 4}; // test
                double[] row2 = new double[]{1, 1, 2, 6}; // test
                double[] row3 = new double[]{2, 1, 1, 7}; // test
                m.setRow(0, row1); // test
                m.setRow(1, row2); // test
                m.setRow(2, row3); // test
                break;
            case 2:
                // input from file
                break;
        }
        m.displayMatrix();
        System.out.println("======================");

        for (int i = 0; i < m.getNCol() - 1; i++) {
            for (int j = 0; j < m.getNRow(); j++) {
                // Transform diagonal element
                if (i == j) {
                    // Transform diagonal element not equal 0
                    if (m.getElmt(i, j) == 0) {
                        int nonZeroIdx = i + 1;
                        while (m.getElmt(i, j) == 0 && nonZeroIdx < m.getNRow()) {
                            if (m.getElmt(nonZeroIdx, j) != 0) {
                                algeo01.function.SwapRows.swap(m, i, nonZeroIdx);
                            }
                            nonZeroIdx++;
                        }
                    }
                    // Tranforms to 1
                    if (m.getElmt(i, j) != 1) {
                        double multiplier = 1 / m.getElmt(i, j);
                        algeo01.function.MultplyRowByConst.mulRowByConst(m, i, multiplier);
                    }
                }

                // Transform non diagonal element
                if (i > j){
                    // Transform to 0
                    double multiplier = m.getElmt(i, j) > 0 ? m.getElmt(i, j) : -(m.getElmt(i,j));
                    if (m.getElmt(i, j) != 0){
                        if (m.getElmt(i, j) > 0){
                            algeo01.function.SubtractRowByRow.subRowByRow(m, i, algeo01.function.MultplyRowByConst.RetMulRowByConst(m, j, multiplier));
                        } else {
                            algeo01.function.AddRowByRow.addRowByRow(m, i, algeo01.function.MultplyRowByConst.RetMulRowByConst(m, j, multiplier));
                        }
                    }
                }
            }
            m.displayMatrix();
            System.out.println("======================");
        }

        // Decides if problem is feasible
        boolean hasManySolutions = true;
        for(int j = 0; j < m.getNCol(); j++){
            if (m.getElmt(m.getNRow() - 1, j) != 0){
                hasManySolutions = false;
            }
        }

        boolean hasNoSolution = true;
        for(int j = 0; j < m.getNCol() - 1; j++){
            if (m.getElmt(m.getNRow() - 1, j) != 0){
                hasNoSolution = false;
            }
        }

        if (!hasNoSolution && !hasManySolutions) {
            System.out.println("Ada gening");
        } else if (hasManySolutions) {
            System.out.println("Banyak solusi.");
        } else if (hasNoSolution) {
            System.out.println("Tidak ada solusi.");
        }

    }
}
