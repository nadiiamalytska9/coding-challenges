package socks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static int sockMerchant(int socksAmount, int[] socks) {
        Set<Integer> indexList = new HashSet<>();
        int socksCount = 0;
        for (int i = 0; i < socksAmount; i++) {
            for (int j = i + 1; j < socksAmount; j++) {
                if (!indexList.contains(j) && !indexList.contains(i)) {
                    if (socks[i] == socks[j]) {
                        socksCount++;
                        indexList.add(i);
                        indexList.add(j);
                    }
                }
            }
        }
        return socksCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
