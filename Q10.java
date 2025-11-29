// Implement binary search(iterative and recursive )


public class Q10 {

    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;

        if (target < arr[mid])
            return binarySearchRecursive(arr, left, mid - 1, target);

        return binarySearchRecursive(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60};
        int target = 40;

        // Iterative Search
        int iterResult = binarySearchIterative(arr, target);
        System.out.println("Iterative Search Result: " + iterResult);

        // Recursive Search
        int recResult = binarySearchRecursive(arr, 0, arr.length - 1, target);
        System.out.println("Recursive Search Result: " + recResult);
    }
}
