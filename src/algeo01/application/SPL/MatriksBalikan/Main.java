package algeo01.application.SPL.MatriksBalikan;

import algeo01.function.Inverse;

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
        for (int i = 0; i < menus.length; i++) {
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
            try {
                selectedMenu = Integer.parseInt(strSelectedMenu);
                isInputInteger = true;

                // Input must be available
                isInputAvail = (0 < selectedMenu && selectedMenu <= menus.length) ? true : false;
            } catch (NumberFormatException e) {
            }
            if (!isInputAvail || !isInputInteger) {
                System.out.println("Masukan tidak tersedia");
            }
        }

        // Calling Another Application
        int nVar = 0, nPers = 0;
        Matrix m, a, b;
        m = new Matrix();
        a = new Matrix();
        b = new Matrix();

        switch (selectedMenu) {
            case 1:
                // input m
                System.out.print("Masukkan banyaknya variabel: ");
                nVar = input.nextInt();
                m.setNCol(nVar);
                System.out.print("Masukkan banyaknya variabel: ");
                nPers = input.nextInt();
                m.setNRow(nPers);
                System.out.println("Masukkan matriks persamaan: ");
                m.readMatrix();

                //input b
                b.setNRow(nPers);
                b.setNCol(1);
                System.out.println("Masukkan matriks hasil: ");
                b.readMatrix();

                /*
                int row, col;
                System.out.print("jumlah baris: ");
                row = input.nextInt();
                System.out.print("jumlah kolom: ");
                col = input.nextInt();
                m = new Matrix(row, col);
                a = new Matrix(row, 1);
                b = new Matrix(row, 1);
                System.out.print("Masukkan matrix persamaan: ");
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        m.setElmt(i, j, input.nextDouble());
                        ;
                    }
                }
                System.out.print("Masukkan matrix hasil persamaan: ");
                for (int i = 0; i < row; i++) {
                    a.setElmt(i, 0, input.nextDouble());
                }
                */
                break;
            case 2:
                // input from file
                System.out.println("Not available");
                break;
        }

        // is Matrix has inverse?
        boolean hasInverse = m.isSquare();

        // isFeasible?
        boolean hasSolution = nVar < nPers;

        // spl algorithm
        for (int i=0; i<m.getNRow(); i++){

        }

        /*
        if (m.getNRow() != m.getNCol()) {
            System.out.println("Matriks tidak dapat dibalikan");
        } else {
            m.displayMatrix();
            a.displayMatrix();
        }
         */

        /*
        double mi[][];
        double mtemp[][];
        mtemp = new double[m.getNRow()][m.getNCol()];
        for (int i = 0; i < m.getNRow(); i++) {
            for (int j = 0; j < m.getNCol(); j++) {
                mtemp[i][j] = m.getElmt(i, j);
            }
        }
        mi = Inverse.inv(mtemp);

        for (int i = 0; i < m.getNRow(); i++) {
            double temp = 0.0;
            for (int j = 0; j < m.getNCol(); j++) {
                temp += mi[i][j] * a.getElmt(j, 0);
            }
            b.setElmt(i, 0, temp);
        }

         */
        //MATRIX B DONE TINGGAL DI PRINT


    }


}

