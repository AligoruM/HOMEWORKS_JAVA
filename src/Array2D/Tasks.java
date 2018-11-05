package Array2D;

import Sorts.Sorts;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Tasks {

    static Random rnd = new Random();

    static void printArr(float[][] arr) {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(df.format(arr[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void taskA() {
        float[][] arr = new float[8][8];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1 + rnd.nextFloat() * (99 - 1);
            }
        }
        double sum_main_d = 0.;
        double multi_main_d = 1.;
        double sum_sec_d = 0.;
        double multi_sec_d = 1.;
        for (int i = 0; i < arr.length; i++) {
            sum_main_d += arr[i][i];
            multi_main_d *= arr[i][i];
            sum_sec_d += arr[i][7 - i];
            multi_sec_d *= arr[i][7 - i];
        }
        printArr(arr);
        System.out.println("Main sum = " + sum_main_d + "; multi = " + multi_main_d);
        System.out.println("Sec sum = " + sum_sec_d + "; multi = " + multi_sec_d);
    }

    static void taskB() {
        float[][] arr = new float[8][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -99 + rnd.nextFloat() * (99 + 99);
            }
        }
        printArr(arr);
        int idx_i=0;
        int idx_j=0;
        float max=-99;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]>max){
                    max=arr[i][j];
                    idx_i=i;
                    idx_j=j;
                }
            }
        }
        System.out.println("Max = " + max + "; i = " + idx_i + "; j = " + idx_j);
    }

    static void taskC(){
        int[][] arr = new int[8][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -10 + rnd.nextInt(21);
            }
        }
        printArr(arr);
        int max = Integer.MIN_VALUE;
        int max_i = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp_multi = 1;
            for (int j = 0; j < arr[i].length; j++) {
                tmp_multi*=arr[i][j];
            }
            if (Math.abs(tmp_multi)>max){
                max_i=i;
                max=tmp_multi;
            }
        }
        System.out.println("Max multi = " + Math.abs(max) + " in row " + (max_i+1) + "(ind = " + max_i + ')');
    }

    static void taskD(){
        int[][] arr = new int[10][7];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(101);
            }
        }
        printArr(arr);
        //было лень писать тут сортировку, просто поменял знак в уже написаной и использовал её
        for (int i = 0; i < arr.length; i++) {
            Sorts.selectionSort(arr[i]);
        }
        System.out.println();
        printArr(arr);
    }

    public static void main(String[] args) {
        taskD();
    }
}
