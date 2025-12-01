// Implement various sorting algorithms including Insertion sort, selection sort, bubble sort, and analyze their performance on different input sizes.

import java.util.*;

public class Q11 {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; 
        }
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(10000);

        return arr;
    }

    public static void measureTime(String algo, int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();
        if (algo.equals("insertion")) insertionSort(copy);
        else if (algo.equals("selection")) selectionSort(copy);
        else if (algo.equals("bubble")) bubbleSort(copy);
        long end = System.nanoTime();

        System.out.println(algo.toUpperCase() + " Sort Time: " + (end - start) + " ns");
    }


    public static void main(String[] args) {

        System.out.println("RASHI YADAV "); 
        System.out.println("2401350003 ");

        int[] sizes = {100, 500, 1000, 5000};

        for (int size : sizes) {
            System.out.println("\n=== INPUT SIZE: " + size + " ===");

            int[] arr = generateRandomArray(size);

            measureTime("insertion", arr);
            measureTime("selection", arr);
            measureTime("bubble", arr);
        }
    }
}
