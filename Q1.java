// Given an array of integers, perform the following operations: traversing , insertion, deletion

import java.util.*;

public class    Q1 {
    public static void main(String[] args) {
         System.out.println("RASHI YADAV ");
         System.out.println("2401350003 ");
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100]; 
        int n;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       

        System.out.print("\nArray elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
      

        System.out.print("\nEnter position to insert (0 to " + n + "): ");
        int pos = sc.nextInt();

        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();

        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }

        arr[pos] = value;
        n++; 

        System.out.print("Array after insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.print("\nEnter position to delete (0 to " + (n - 1) + "): ");
        int delPos = sc.nextInt();

        
        for (int i = delPos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        n--; 

        System.out.print("Array after deletion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
