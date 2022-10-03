package algeo01.application.InterpolasiPolinom;

import java.util.Scanner;

import algeo01.function.Determinant;

import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan banyak titik = ");
        int n = sc.nextInt();
        double[][] arrinput;
        arrinput = new double[n][2];

        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                arrinput[i][j] = sc.nextDouble();
            }
        }

        double[][] a;
        a = new double[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = Math.pow(arrinput[i][0], j);
            }
        }

        double[] b;
        b = new double[n];
        for(int i=0; i<n; i++){
            b[i] = arrinput[i][1];
        }
        
        double detutama = algeo01.function.Determinant.det(a,n);

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
        System.out.print("Masukkan titik yang dicari = ");
        double x_pertanyaan = sc.nextDouble();

        for(int i=0; i<n; i++){
            ans += isi_a[i] * (Math.pow(x_pertanyaan,i));
        }
        System.out.println("hasilnya adalah " + ans);
        sc.close();
    }
}
