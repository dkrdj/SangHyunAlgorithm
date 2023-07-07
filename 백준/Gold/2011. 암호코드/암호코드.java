import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        if (arr[0] == '0') {
            System.out.println(0);
            return;
        }
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i - 2] != '0' && arr[i - 1] != '0') {
                int num = Integer.parseInt(String.valueOf(arr[i - 2]) + arr[i - 1]);
                if (num <= 26) {
                    dp[i] += dp[i - 2];
                    dp[i] %= 1000000;
                }
            }
            if (arr[i - 1] == '0' && (arr[i - 2] > '2' || arr[i - 2] == '0')) {
                System.out.println(0);
                return;
            }
            if (arr[i - 1] == '0') {
                dp[i] = dp[i - 2];
            }

        }
        System.out.println(dp[n]);
    }

}