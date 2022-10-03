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
        System.out.println("SPL METODE MATRIKS BALIKAN");
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
        Matrix m, a, b, mInv;
        m = new Matrix();
        a = new Matrix();
        b = new Matrix();
        mInv = new Matrix();

        switch (selectedMenu) {
            case 1:
                // input m
                System.out.print("Masukkan banyaknya variabel: ");
                nVar = input.nextInt();
                m.setNCol(nVar);

                System.out.print("Masukkan banyaknya persamaan: ");

                nPers = input.nextInt();
                m.setNRow(nPers);
                System.out.println("Masukkan matriks persamaan: ");
                m.readMatrix();

                //input b
                b.setNRow(nPers);
                b.setNCol(1);
                System.out.println("Masukkan matriks hasil: ");
                b.readMatrix();

                break;
            case 2:
                // input from file
                System.out.println("Not available");
                algeo01.application.SPL.MatriksBalikan.Main.main(null);
                break;
        }

        // is Matrix has inverse?
        boolean hasInverse = m.isSquare();

        // isFeasible?

        boolean hasSolution = nVar <= nPers;

        double temp;


        if (!(hasInverse && hasSolution)) {
            System.out.println("Matriks tidak dapat dibalikan");
        } else {
            System.out.println("Matriks hasil metode Matriks Balikan:");
            // b.displayMatrix();
            // System.out.println("Matriks balikan:");
            mInv = Inverse.master(m);
            mInv.displayMatrix();

            System.out.println("Solusi SPL:");
            for (int i = 0; i < nVar; i++) {
                temp = 0;
                for (int j = 0; j < nPers; j++) {
                    temp=temp+mInv.getElmt(i,j)*b.getElmt(j,0);
                }
                System.out.println("x"+(i+1)+" = "+temp);
            }
            
        }

        algeo01.application.Main.returnToMenu();
    }


}

