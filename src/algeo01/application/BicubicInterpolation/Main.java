package algeo01.application.BicubicInterpolation;

import algeo01.data.Matrix;

import java.util.Scanner;

import static algeo01.function.BicubicInterpolator.getValue;


public class Main {
    public static void main(String[] args) {
        // Available menus
        final String[] menus = new String[]{
                "Console",
                "Text File",
        };

        // Display menu
        System.out.println("Interpolasi Bicubic");
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
        double x = 0, y = 0, hasil;
        Matrix m = new Matrix();
        double[][] awal = new double[4][4];
        switch (selectedMenu) {
            case 1:
                System.out.println("Masukkan matrix 4x4: ");
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        awal[i][j] = input.nextDouble();
                    }
                }
                System.out.println("Masukkan nilai x: ");
                x = input.nextDouble();
                System.out.println("Masukkan nilai y: ");
                y = input.nextDouble();
                break;
            case 2:
                // input from file
                System.out.println("Not available yet");
                break;


        }
        System.out.println("Hasil interpolasi: " + getValue(awal, x, y));

        algeo01.application.Main.returnToMenu(10);
    }
}
