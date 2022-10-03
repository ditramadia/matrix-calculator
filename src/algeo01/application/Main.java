package algeo01.application;

import java.util.*;

import algeo01.function.Determinant;
import algeo01.function.*;

public class Main{
    public static void main(String[] args) {
        // Available menus
        final String[] menus = new String[]{
                "Sistem Persamaan Linear",
                "Determinan",
                "Matriks Balikan",
                "Interpolasi Polinom",
                "Interpolasi Bicubic",
                "Regresi Linier Berganda",
                "Keluar",
        };

        // Display menu
        System.out.println("MENU");
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
                // Call SPL
                algeo01.application.SPL.Main.main(null);
                break;
            case 2:
                // Call Determinant App
                algeo01.application.Determinant.Main.main(null);
                break;
            case 3:
                // Call Inverse App
                algeo01.application.inverse.Main.main(null);
                break;
            case 4:
                // Call InterpolasiPolimomApp
                algeo01.application.InterpolasiPolinom.Main.main(null);
                break;
            case 5:
                // Call Interpolasi Bicubic
                algeo01.application.BicubicInterpolation.Main.main(null);
                break;
            case 6:
                // Call Regresi Linear Berganda
                algeo01.application.linearRegression.Main.main(null);
                break;
            case 7:
                // Exit JVM
                algeo01.application.Main.exit();
                break;
        }

        input.close();
    }

    public static void returnToMenu(){
        // Available menus
        final String[] menus = new String[]{
                "Coba lagi",
                "Kembali Ke Menu",
                "Keluar",
        };

        // Display menu
        System.out.println("MENU");
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
                algeo01.application.SPL.Gauss.Main.main(null);
                break;
            case 2:
                algeo01.application.Main.main(null);
                break;
            case 3:
                algeo01.application.Main.exit();
                break;
        }
    }

    public static void exit(){
        System.out.println("Program dihentikan");
        System.exit(0);
    }
}
