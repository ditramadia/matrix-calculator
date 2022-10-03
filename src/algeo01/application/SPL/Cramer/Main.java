package algeo01.application.SPL.Cramer;

import java.util.Scanner;

import algeo01.data.Matrix;
import algeo01.function.Determinant;

public class Main {
    public static void main(String[] args) {
        // Available menus
        final String[] menus = new String[]{
                "Console",
                "Text File",
        };

        // Display menu
        System.out.println("SPL METODE CRAMER");
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
        Scanner sc = new Scanner(System.in);
        int m = 0, n = 0, kasus = 1;
        double[][] arr = new double[n][m];
        double[][] a = new double[n][m];
        double[] b = new double[m];
        switch (selectedMenu) {
            case 1:
                kasus = 1;
                // kasus 1 untuk ada 1 solusi, 2 untuk tidak ada solusi, 3 untuk solusi banyak/tak terhingga
                System.out.print("input banyak variabel: ");
                m = sc.nextInt();
                System.out.print("input banyak persamaan: ");
                n = sc.nextInt();
                while (n != m) {
                    System.out.println("Inputan invalid !!\nUntuk kaidah Cramer, banyak variabel harus sama dengan banyak persamaan karena menggunakan Determinan dalam penghitungannya");
                    System.out.print("input banyak persamaan : ");
                    n = sc.nextInt();
                    System.out.print("input banyak variabel : ");
                    m = sc.nextInt();
                }
                // System.out.println(str);
                arr = new double[n][n];
                // algeo01.function.Determinant det = new Determinant();
                System.out.println("Input matriks persamaan :");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = sc.nextDouble();
                    }
                }

                a = new double[n][n];
                b = new double[n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        a[i][j] = arr[i][j];
                    }
                }

                System.out.println("Masukkan matriks hasil :");
                for (int i = 0; i < n; i++) {
                    b[i] = sc.nextDouble();
                }
                break;
            case 2:
                // input from file
                System.out.println("Not available yet");
                algeo01.application.SPL.Cramer.Main.main(null);
                break;
        }

        double detutama = algeo01.function.Determinant.det(a, n);
        if (detutama == 0) kasus = 2;
        // System.out.println("Det utama = " + detutama);

        double[] hasil_x;
        hasil_x = new double[n];
        double[][] temp;
        temp = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) temp[j][k] = b[j];
                    else temp[j][k] = a[j][k];
                }
            }
            hasil_x[i] = algeo01.function.Determinant.det(temp, n) / detutama;
            if (algeo01.function.Determinant.det(temp, n) == 0 && kasus == 2) kasus = 3;
            // System.out.println("det temp = " + algeo01.function.Determinant.det(temp,n));
            System.out.println("Hasil matriks setelah diubah per kolom dengan matriks hasil :");
            for (int l = 0; l < n; l++) {
                for (int o = 0; o < n; o++) {
                    System.out.print(temp[l][o] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            // System.out.println("");
        }

        // Matrix mTemp = new Matrix();
        // mTemp.setTab(temp);
        // System.out.println("Matrix hasil kaidah Cramer:");
        // mTemp.displayMatrix();
        if (kasus == 1) {
            System.out.println("Solusi SPL:");
            for (int i = 0; i < n; i++) {
                System.out.println("x_" + i + " = " + hasil_x[i]);
            }
        } else if (kasus == 2) {
            System.out.println("Tidak ada solusi untuk persamaan ini");
        } else {
            System.out.println("Terdapat solusi banyak/tidak terhingga untuk persamaan ini");
        }

        algeo01.application.Main.returnToMenu(4);
    }
}
