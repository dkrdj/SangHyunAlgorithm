import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int ans, N;
    static boolean[][] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new boolean[N][N];
            ans = 0;
            queen(0, 0);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void queen(int idx, int visited) {
        if (idx == N) {
            ans++;
            return;
        }
        outer: for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0) {
                for (int j = 1; idx - j >= 0; j++) {
                    if (i - j >= 0 && arr[idx - j][i - j]) {
                        continue outer;
                    }
                    if (i + j < N && arr[idx - j][i + j]) {
                        continue outer;
                    }
                }
                arr[idx][i] = true;
                queen(idx + 1, visited | (1 << i));
                arr[idx][i] = false;
            }
        }
 
    }
 
}