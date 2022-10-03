package algeo01.application.InterpolasiPolinom;

import java.util.Scanner;

import algeo01.data.Matrix;
import algeo01.function.Determinant;

import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        // Available menus
        final String[] menus = new String[]{
                "Console",
                "Text File",
        };

        // Display menu
        System.out.println("INTERPOLASI POLINOM");
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
        Scanner sc = new Scanner(System.in);
        int n = 0;
        double[][] arrinput = new double[0][0], a = new double[0][0];
        double[] b = new double[0];
        double detutama = 0;

        switch (selectedMenu) {
            case 1:
                System.out.print("Masukkan banyak titik: ");
                n = sc.nextInt();
                arrinput = new double[n][2];

                System.out.println("Masukkan titik-titiknya:");
                for(int i=0; i<n; i++){
                    for(int j=0; j<2; j++){
                        arrinput[i][j] = sc.nextDouble();
                    }
                }

                a = new double[n][n];

                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        a[i][j] = Math.pow(arrinput[i][0], j);
                    }
                }

                b = new double[n];
                for(int i=0; i<n; i++){
                    b[i] = arrinput[i][1];
                }

                detutama = algeo01.function.Determinant.det(a,n);

                break;
            case 2:
                // input from file
                System.out.println("Not available yet");
                algeo01.application.InterpolasiPolinom.Main.main(null);
                break;
        }

        double[] isi_a;
        isi_a = new double[n];

        for(int i=0; i<n; i++){
            double[][] temp;
            temp = new double[n][n];
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(k == i) temp[j][k] = b[j];
                    else temp[j][k] = a[j][k];
                }
            }
            isi_a[i] = algeo01.function.Determinant.det(temp,n) / detutama;
        }

        double ans = 0;
        System.out.print("Masukkan titik yang dicari: ");
        double x_pertanyaan = sc.nextDouble();

        for(int i=0; i<n; i++){
            ans += isi_a[i] * (Math.pow(x_pertanyaan,i));
        }
        System.out.println("f(" + x_pertanyaan + ") = " + ans);

        algeo01.application.Main.returnToMenu(9);
    }
}
