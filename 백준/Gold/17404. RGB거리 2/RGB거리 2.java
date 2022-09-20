import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        int[][] paint = new int[N][3];
        int[] ans = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    dp[0][j] = paint[0][j];
                else
                    dp[0][j] = 1001;
            }
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[j][k] = Math.min(dp[j - 1][(k + 1) % 3], dp[j - 1][(k + 2) % 3]) + paint[j][k];
                }
            }
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    ans[j] = Math.min(dp[N - 1][(j + 1) % 3], dp[N - 1][(j + 2) % 3]);
            }
        }
        System.out.println(Math.min(Math.min(ans[0], ans[1]), ans[2]));
    }
}