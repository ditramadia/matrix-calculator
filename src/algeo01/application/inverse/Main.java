package algeo01.application.inverse;

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
                // input m
                System.out.print("Masukkan banyaknya baris: ");
                m.setNRow(input.nextInt());
                System.out.print("Masukkan banyaknya kolom: ");
                m.setNCol(input.nextInt());
                System.out.println("Masukkan matriks: ");
                m.readMatrix();
                input.close();
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

        // is Matrix has inverse
        if(m.isSquare() && algeo01.function.Determinant.det(m.getTab(), m.getNRow()) != 0){
            // initialize result
            Matrix mRes = new Matrix(m.getNRow(), m.getNCol());
            // Inverse
            mRes.setTab(algeo01.function.Inverse.inv(m.getTab()));
            // Display result
            System.out.println("Matriks yang diinput: ");
            m.displayMatrix();
            System.out.println("Inverse matriks: ");
            mRes.displayMatrix();
        }else{
            System.out.println("Matriks tidak memiliki balikan.");
        }

        algeo01.application.Main.returnToMenu();
    }
}
