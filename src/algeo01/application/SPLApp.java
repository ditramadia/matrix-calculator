package algeo01.application;

import java.util.Scanner;

public class SPLApp {
    public static void main(String[] args) {
        // Available menus
        final String[] menus = new String[]{
                "Metode Eliminasi Gauss",
                "Metode Eliminasi Gauss-Jordan",
                "Metode Matriks Balikan",
                "Kaidah Cramer",
                "Kembali"
        };

        // Display menu
        System.out.println("MENU SISTEM PERSAMAAN LINEAR");
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
            System.out.print("Pilih menu: ");
            strSelectedMenu = input.nextLine();
            // Input must be an integer
            try{
                selectedMenu = Integer.parseInt(strSelectedMenu);
                isInputInteger = true;

                // Input must be available
                isInputAvail = (0 < selectedMenu && selectedMenu <= menus.length) ? true : false;
            } catch(NumberFormatException e) {}
            if(!isInputAvail || !isInputInteger){
                System.out.println("Menu tidak tersedia");
            }
        }

        // Calling Another Application
        switch (selectedMenu) {
            case 1:
                // Call GaussApp
                break;
            case 2:
                // Call GaussJordanApp
                break;
            case 3:
                // Call MatriksBalikanApp
                break;
            case 4:
                // Call KaidahCramerApp
                break;
            case 5:
                // Back
                Main.main(null);
                break;
        }
    }
}
