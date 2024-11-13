import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n <= 0) {
            System.out.println(1);
            return;
        }
        long[][][] dp = new long[n + 1][2][3];
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] += dp[i - 1][j][k];
                    if (j + 1 < 2) {
                        dp[i][j + 1][0] += dp[i - 1][j][k];
                    }
                    if (k + 1 < 3) {
                        dp[i][j][k + 1] += dp[i - 1][j][k];
                    }
                }
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] %= 1000000;
                }
            }
        }
        long answer = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                answer += dp[n][j][k];
            }
        }
        System.out.println(answer % 1000000);
    }

}