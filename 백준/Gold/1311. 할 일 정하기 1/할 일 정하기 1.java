import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp, arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][(1 << N)];
        System.out.println(dp(0, 0));

    }

    static int dp(int idx, int visited) {
        if (idx == N)
            return 0;
        if (dp[idx][visited] != 0)
            return dp[idx][visited];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0)
                min = Math.min(min, arr[idx][i] + dp(idx + 1, visited | (1 << i)));
        }
        dp[idx][visited] = min;
        return dp[idx][visited];
    }
}