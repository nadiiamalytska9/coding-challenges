package challenges.solution;

public class MinimumSwaps {
    static int minimumSwaps(int[] arr) {
        int swapCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i]) {
                int t = i;
                while (arr[t] != i + 1) {
                    t++;
                }
                swap(arr, i, t);
                swapCount++;
            }
        }
        return swapCount;
    }

    private static void swap(int[] arr, int i, int t) {
        int temp = arr[t];
        arr[t] = arr[i];
        arr[i] = temp;
    }
}
