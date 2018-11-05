package Array1Dim;

import java.util.*;

public class Tasks {

    static Random rnd = new Random();

    static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println();
    }

    static void taskA() {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2 + 1;
        }

        printArr(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    static void taskB() {
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(11);
        }

        int even_count = 0;

        for (int anArr : arr) {
            if (anArr % 2 == 0) {
                even_count++;
            }
            System.out.print(anArr + " ");
        }
        System.out.println("\nEven count = " + even_count + "\nOdd count = " + (arr.length - even_count));
    }

    static void taskC() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(101);
        }
        printArr(arr);
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = 0;
        }
        printArr(arr);
    }

    static void taskD() {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -50 + rnd.nextInt(101);
        }
        printArr(arr);
        int min_i = 0;
        int max_i = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[min_i] >= arr[i]) {
                min_i = i;
            }
            if (arr[max_i] <= arr[i]) {
                max_i = i;
            }
        }
        System.out.println("Min ind = " + min_i + " value = " + arr[min_i]);
        System.out.println("Max ind = " + max_i + " value = " + arr[max_i]);
    }

    static void taskE() {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rnd.nextInt(11);
            arr2[i] = rnd.nextInt(11);
        }
        float arr1_mean = 0;
        float arr2_mean = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr1_mean += arr1[i];
            arr2_mean += arr2[i];
        }
        arr1_mean = arr1_mean / arr1.length;
        arr2_mean = arr2_mean / arr2.length;
        if (arr1_mean == arr2_mean) {
            System.out.println("equal");
        } else if (arr1_mean > arr2_mean) {
            System.out.println("average of first array is more " + arr1_mean);
        } else {
            System.out.println("average of second array is more " + arr2_mean);
        }
    }

    static void taskF() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1 + rnd.nextInt(3);
        }
        int[] count = {0, 0, 0};
        for (int anArr : arr) {
            switch (anArr) {
                case -1:
                    count[0]++;
                    break;
                case 0:
                    count[1]++;
                    break;
                case 1:
                    count[2]++;
                default:
                    break;
            }
        }
        int max = Arrays.stream(count).max().getAsInt();
        printArr(count);
        for (int i = 0; i < 3; i++) {
            if(count[i]==max){
                System.out.print((i-1) + " ");
            }
        }
    }

    public static void main(String[] args) {
        taskF();
    }
}
