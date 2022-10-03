package algeo01.application.inverse.inverseAdj;

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
        System.out.println("MATRIKS BALIKAN METODE ADJOIN");
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
                algeo01.application.inverse.inverseAdj.Main.main(null);
                break;
        }

        // is Matrix has inverse
        if(m.isSquare() && algeo01.function.Determinant.det(m.getTab(), m.getNRow()) != 0){
            // initialize result
            Matrix mRes = new Matrix(m.getNRow(), m.getNCol());
            // calculate inverse
            System.out.println("Matrix balikan:");
            mRes = algeo01.function.Inverse.master(m);
            mRes.displayMatrix();
        }else{
            System.out.println("Matriks tidak memiliki balikan.");
        }

        algeo01.application.Main.returnToMenu(7);
    }
}
