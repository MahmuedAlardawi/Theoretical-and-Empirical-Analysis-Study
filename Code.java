/*
students:
- Mahmued Alardawi - 2135209
- Thamer S.Almalki - 2136185
- Abdulelah Ali Alturki - 2136110
- Abdulkareem Abdullah Al-Ghamdi - 2135037

Course: CPCS-223
Section: CS2
Date: 29/1/2023
*/

import java.util.*;

public class CPCS223_project {
    // main
    public static void main (String [] args) {
        Output(10);
        Output(100);
        Output(1000);
        Output(10000);
        Output(100000);
    }

    // Output
    public static void Output(int size) {
        long startTime, estimatedTime, avgInsertion=0, avgSelection=0, avgQuicksort=0;
        System.out.println("N = " + size);


        for (int i = 1; i < 6; i++) {
            System.out.println("Iteration " + i + " : ");
            int[] array = array(size);

            int[] insertionArray = new int[size];
            System.arraycopy(array, 0, insertionArray, 0, size);
            System.out.print("Insertion sort: ");
            startTime = System.nanoTime();
            insertion(insertionArray);
            estimatedTime = System.nanoTime() - startTime;
            avgInsertion += estimatedTime;
            System.out.println("Running time in nanoseconds: " + estimatedTime);

            int[] selectionArray = new int[size];
            System.arraycopy(array, 0, selectionArray, 0, size);
            System.out.print("selection sort: ");
            startTime = System.nanoTime();
            selection(selectionArray);
            estimatedTime = System.nanoTime() - startTime;
            avgSelection += estimatedTime;
            System.out.println("Running time in nanoseconds: " + estimatedTime);

            int[] QuicksortArray = new int[size];
            System.arraycopy(array, 0, QuicksortArray, 0, size);
            System.out.print("Quicksort sort: ");
            startTime = System.nanoTime();
            Quicksort(QuicksortArray);
            estimatedTime = System.nanoTime() - startTime;
            avgQuicksort += estimatedTime;
            System.out.println("Running time in nanoseconds: " + estimatedTime);
        }
        System.out.println("---------------------");
        System.out.println("Insertion average time: " + avgInsertion / 5);
        System.out.println("Selection average time: " + avgSelection / 5);
        System.out.println("Quicksort average time: " + avgQuicksort / 5);
        System.out.println("---------------------");
        System.out.println();
    }

    // Random array
    public static int[] array(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            int n = 0;
            while (n == 0) {
                n = (int) (Math.random() * 9999);
            }
            array[i] = (int) (Math.random() * 9999);
        }

        return array;
    }

    // Insertion
    public static void insertion(int[] array) {
        int key=0, i=0;
        for (int p = 1; p < array.length; p++) {
            key = array[p];
            i = p - 1;

            while (i > 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i +1] = key;
        }
    }

    // Selection
    public static void selection(int[] array) {
        int minimum=0, index=0;

        for (int p = 0; p < array.length; p++) {
            index = p;
            for (int i = p + 1; i < array.length; i++) {
                if (array[i] < array[index]) {
                    index = i;
                }
            }
            minimum = array[index];
            array[index] = array[p];
            array[p] = minimum;
        }
    }

    // Quicksort
    private static int partition(int[] array, int low, int high) {
        int l = (low - 1);

        for (int r = low; r < high; r++) {
            if (array[r] <= array[high]) {
                l++;

                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }

        }

        int temp = array[l + 1];
        array[l + 1] = array[high];
        array[high] = temp;

        return (l + 1);
    }
    private static void Quicksort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            Quicksort(array, low, p - 1);
            Quicksort(array, p + 1, high);
        }
    }
    static void Quicksort(int[] array) {
        Quicksort(array, 0, array.length - 1);
    }
}