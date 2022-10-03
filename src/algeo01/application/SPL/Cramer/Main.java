package algeo01.application.SPL.Cramer;

import java.util.Scanner;

import algeo01.function.Determinant;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input banyak baris = ");
        int n = sc.nextInt();
        System.out.print("input banyak kolom = ");
        int m = sc.nextInt();
        // String str = sc.next();
        // System.out.println("jumlah baris = n, jumlah kolom n+1");
        while(n != m-1){
            System.out.println("Inputan Salah !!\nUntuk kaidah Cramer, banyak kolom = banyak baris + 1 karena menggunakan Determinan dalam penghitungannya");
            n = sc.nextInt();
            m = sc.nextInt();
        }
        // System.out.println(str);
        double[][] arr;
        arr = new double[n][n+1];
        // algeo01.function.Determinant det = new Determinant();

        for(int i=0; i<n; i++){
            for(int j=0; j<n+1; j++){
                arr[i][j] = sc.nextDouble();
            }
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n+1; j++){
        //         System.out.print(arr[i][j]);
        //         System.out.print(" ");
        //     }
        //     System.out.println("");
        double[][] a;
        a = new double[n][n];
        double[] b;
        b = new double[n];

        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                a[i][j] = arr[i][j];
            }
        }

        for(int i=0; i<n;i++){
            b[i]= arr[i][n];
        }

        double detutama = algeo01.function.Determinant.det(a,n);
        System.out.println("Det utama = " + detutama);

        double[] hasil_x;
        hasil_x = new double[n];

        for(int i=0; i<n; i++){
            double[][] temp;
            temp = new double[n][n];
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(k == i) temp[j][k] = b[j];
                    else temp[j][k] = a[j][k];
                }
            }
            hasil_x[i] = algeo01.function.Determinant.det(temp,n) / detutama;
            System.out.println("det temp = " + algeo01.function.Determinant.det(temp,n));
            for(int l=0; l<n; l++){
                for(int o=0; o<n; o++){
                    System.out.print(temp[l][o] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        }

        for(int i=0; i<n; i++){
            System.out.println("x_" + i + " = " + hasil_x[i]);
        }
        sc.close();
    }    
}
