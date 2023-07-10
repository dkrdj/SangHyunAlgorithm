import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] isVip = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            isVip[num] = true;
        }
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (!isVip[i]) {
                dp[i] = dp[i - 1] + (isVip[i - 1] ? 0 : dp[i - 2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[N]);
    }
}