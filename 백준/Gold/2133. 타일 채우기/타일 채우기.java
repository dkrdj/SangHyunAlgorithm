import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[N + 1];
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 4; i <= N; i += 2) {
            dp[i - 1] = dp[i - 2] * 2 + dp[i - 3];
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N]);
    }
}