// Implement various sorting algorithms including Quick Sort, Merge Sort, Heap Sort, and analyze their performance on different input sizes. Ensure the implementation handles edge cases such as duplicate values and nearly sorted arrays

import java.util.*;

public class Q12 {


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {  
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return (i + 1);
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {   
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }


    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(10000);   
        return arr;
    }

    public static int[] generateNearlySortedArray(int size) {
        int[] arr = generateRandomArray(size);
        Arrays.sort(arr);
       
        for (int i = 0; i < size / 20; i++)
            arr[i] = arr[i] + (i % 5);
        return arr;
    }

    public static void measure(String algorithm, int[] input) {
        int[] arr = Arrays.copyOf(input, input.length);

        long start = System.nanoTime();
        if (algorithm.equals("quick"))
            quickSort(arr, 0, arr.length - 1);
        else if (algorithm.equals("merge"))
            mergeSort(arr, 0, arr.length - 1);
        else if (algorithm.equals("heap"))
            heapSort(arr);
        long end = System.nanoTime();

        System.out.println(algorithm.toUpperCase() + " Sort Time: " + (end - start) + " ns");
    }


    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 20000};

        for (int size : sizes) {
            System.out.println("\n====== INPUT SIZE: " + size + " ======");

            int[] randomInput = generateRandomArray(size);
            int[] nearlySortedInput = generateNearlySortedArray(size);

            System.out.println("\n-- Random Input --");
            measure("quick", randomInput);
            measure("merge", randomInput);
            measure("heap", randomInput);

            System.out.println("\n-- Nearly Sorted Input --");
            measure("quick", nearlySortedInput);
            measure("merge", nearlySortedInput);
            measure("heap", nearlySortedInput);
        }
    }
}
