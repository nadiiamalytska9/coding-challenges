package challenges.solution;

public class BubbleSort {
    static void countSwaps(int[] a) {
        int swapCount = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    swapCount++;
                }
            }
        }
        System.out.println("Array is sorted in " + swapCount + " swaps. First Element: " + a[0] + " Last Element: " + a[a.length - 1]);
    }
}
