package algeo01.application;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Available menus
        final String[] menus = new String[]{
                "Sistem Persamaan Linear",
                "Determinan",
                "Matriks Balikan",
                "Interpolasi Polinom",
                "Interpolasi Bicubic",
                "Regresi Linier Berganda",
                "Keluar"
        };

        // Display menu
        System.out.println("MENU");
        for (int i = 0; i < menus.length; i++){
            System.out.println((i + 1) + ". " + menus[i]);
        }
        // Asking for user input
        System.out.print("Pilih menu: ");
        int selectedMenu = sc.nextInt();
        boolean isSelectedValid = (0 < selectedMenu) && (selectedMenu <= menus.length);
        // Input validation
        while (!isSelectedValid){
            System.out.println("Menu tidak tersedia. Harap pilih kembali.");
            System.out.print("Pilih menu: ");
            selectedMenu = sc.nextInt();
            isSelectedValid = (0 < selectedMenu) && (selectedMenu <= menus.length);
        }

        // Calling Another Application
        switch (selectedMenu) {
            case 1:
                // Call SPLApp
                break;
            case 2:
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
                System.exit(0);
                break;
        }
    }
}
