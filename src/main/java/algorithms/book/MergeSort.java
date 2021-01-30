package algorithms.book;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        int s = arr.length;
        if (s < 2) return;

        int lSize = s / 2;
        int[] l = new int[lSize];
        int rSize = s - lSize;
        int[] r = new int[rSize];

        for (int i = 0; i < lSize; i++) {
            l[i] = arr[i];
        }

        for (int i = 0; i < rSize; i++) {
            r[i] = arr[i + lSize];
        }

        mergeSort(l);
        mergeSort(r);

        merge(l, r, lSize, rSize, arr);
    }

    private static void merge(int[] l, int[] r, int lSize, int rSize, int[] result) {
        int k = 0;
        int i = 0;
        int j = 0;

        if (l[lSize - 1] < r[0]) {
            while (i < lSize) {
                result[k++] = l[i++];
            }
            while (j < rSize) {
                result[k++] = r[j++];
            }
            return;
        }

        while (i < lSize && j < rSize) {
            if (l[i] <= r[j]) {
                result[k++] = l[i++];
            } else {
                result[k++] = r[j++];
            }
        }

        while (i < lSize) {
            result[k++] = l[i++];
        }
        while (j < rSize) {
            result[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 3, 12, 0};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
