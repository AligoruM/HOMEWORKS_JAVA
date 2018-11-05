package Sorts;

import java.util.Arrays;
import java.util.Random;

public class Sorts {

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] > arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArr(int[] arr){
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10000];
        Random rnd = new Random();
        for(int i = 0; i<10000; i++){
            array[i]= -5000 + rnd.nextInt(10000);
        }

        long startTime = System.nanoTime();
        bubbleSort(array);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Bubble sort time:\t" + estimatedTime);

        for(int i = 0; i<10000; i++){
            array[i]= -5000 + rnd.nextInt(10000);
        }
        startTime = System.nanoTime();
        selectionSort(array);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Select. sort time:\t" + estimatedTime);

        for(int i = 0; i<10000; i++){
            array[i]= -5000 + rnd.nextInt(10000);
        }
        startTime = System.nanoTime();
        Arrays.sort(array);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Default sort time:\t" + estimatedTime);
    }
}
