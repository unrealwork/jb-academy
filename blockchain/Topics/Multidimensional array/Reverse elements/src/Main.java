class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        // write your code here
        for (int[] arr : twoDimArray) {
            reverse(arr);
        }
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
