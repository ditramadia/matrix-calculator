package algeo01.application.inverse.inverseOBE;

import algeo01.data.Matrix;
import algeo01.function.Inverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Available menus
        final String[] menus = new String[]{
                "Console",
                "Text File",
        };

        // Display menu
        System.out.println("Matriks Balikan metode OBE");
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
                System.out.println("Not available yet");
                algeo01.application.inverse.inverseAdj.Main.main(null);
            }
        }

        // Calling Another Application
        Matrix m = new Matrix();
        switch (selectedMenu) {
            case 1:
                // input m
                System.out.print("Masukkan banyaknya baris: ");
                m.setNRow(input.nextInt());
                System.out.print("Masukkan banyaknya kolom: ");
                m.setNCol(input.nextInt());
                System.out.println("Masukkan matriks: ");
                m.readMatrix();
                break;
            case 2:
                // input from file
                System.out.println("Not available yet");
                algeo01.application.inverse.inverseOBE.Main.main(null);
                break;
        }

        // is Matrix has inverse
        if(m.isSquare() && algeo01.function.Determinant.det(m.getTab(), m.getNRow()) != 0){
            // initialize identity Matrix
            Matrix mIdentity = new Matrix(m.getNRow(), m.getNCol());
            for(int i = 0; i < mIdentity.getNRow(); i++){
                for(int j = 0; j < mIdentity.getNCol(); j++){
                    if (i == j){
                        mIdentity.setElmt(i, j, 1);
                    }else{
                        mIdentity.setElmt(i, j, 0);
                    }
                }
            }
            // Merge matrix m and mIdentity
            Matrix mMerged = new Matrix();
            mMerged.mergeToRight(m, mIdentity);
            System.out.println("Matriks Augmented:");
            mMerged.displayMatrix();
            // Calculate inverse
            algeo01.function.InverseOBE.inverseOBE(mMerged);
            System.out.println("Matriks setelah eliminasi Gauss Jordan:");
            mMerged.displayMatrix();
            // Unmerge Matrix m
            mMerged.unMergeRetRight();
            System.out.println("Matriks balikan:");
            mMerged.displayMatrix();

        }else{
            System.out.println("Matriks tidak memiliki balikan.");
        }

        algeo01.application.Main.returnToMenu(8);
    }
}
