package challenges.solution;

public class FibonacciNumbers {
    public static int fibonacci(int n) {
        if (n < 3) return 1;
        int[] fibValues = new int[]{1, 1};
        int k = 3;
        int sumValue;
        while (k <= n) {
            sumValue = fibValues[0] + fibValues[1];
            fibValues[0] = fibValues[1];
            fibValues[1] = sumValue;
            k++;
        }
        return fibValues[1];
    }
}
