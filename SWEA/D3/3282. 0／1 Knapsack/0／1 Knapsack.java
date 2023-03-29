import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Stuff[] stuffs = new Stuff[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                stuffs[i] = new Stuff(v, c);
            }
            Arrays.sort(stuffs, (Comparator.comparingInt(o -> o.volumn)));
            int[][] dp = new int[N + 1][K + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    if (j >= stuffs[i - 1].volumn)
                        dp[i][j] = Math.max(dp[i - 1][j - stuffs[i - 1].volumn] + stuffs[i - 1].cost, dp[i - 1][j]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
            sb.append(' ').append(dp[N][K]).append("\n");
        }
        System.out.println(sb);
    }
}

class Stuff {
    int volumn;
    int cost;

    public Stuff(int volumn, int cost) {
        this.volumn = volumn;
        this.cost = cost;
    }
}

