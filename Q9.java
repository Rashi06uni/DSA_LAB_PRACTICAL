// Implement linear search 

public class Q9 {


    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }

        return -1; 
    }

    public static void main(String[] args) {

        System.out.println("RASHI YADAV "); 
        System.out.println("2401350003 ");

        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;

        int result = linearSearch(arr, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found in the array.");
    }
}
