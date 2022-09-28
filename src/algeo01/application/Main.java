
import java.util.*;

public class Main {
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
                // Call SPLApp
                break;
            case 2:
                Determinant.main(args);
                // Call DeterminanApp
                break;
            case 3:

                // Call MatrikBalikanApp
                break;
            case 4:
                // Call InterpolasoPolimomApp
                break;
            case 5:
                // Call Interpolasi Bicubic
                break;
            case 6:
                // Call Regresi Linear Berganda
                break;
            case 7:
                // Exit JVM
                System.out.println("Program dihentikan");
                System.exit(0);
                break;
        }
    }
}
