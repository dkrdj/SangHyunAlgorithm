import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] men = new int[N + 1];
        int[] women = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            men[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            women[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(men);
        Arrays.sort(women);
        int max = Math.max(N, M);
        int min = Math.min(N, M);
        int[][] dp = new int[min + 1][max + 1];
        for (int i = 1; i <= min; i++) {
            dp[i][i] = dp[i - 1][i - 1] + Math.abs(men[i] - women[i]);
        }
        for (int i = 1; i <= min; i++) {
            for (int j = i + 1; j <= max; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], Math.abs(men.length == max + 1 ? men[j] - women[i] : women[j] - men[i]) + dp[i - 1][j - 1]);
            }
        }
        System.out.println(dp[min][max]);
    }
}
