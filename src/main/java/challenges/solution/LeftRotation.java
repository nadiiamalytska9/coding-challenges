package challenges.solution;

public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {
        int[] arr = new int[a.length];
        int N = a.length;
        for (int i = 0 ; i < N;  i++){
            arr[i] = a[(i+d)%N];
        }
        return arr ;
    }
}
