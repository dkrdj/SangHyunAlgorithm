import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] dr = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dc = {1, 0, -1, 1, 0, -1, 1, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            sb.append('#').append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                char[] charArr = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    if (charArr[j] == '*') {
                        visited[i][j] = true;
                        arr[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int cnt = 0;
                        for (int k = 0; k < 8; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                if (visited[nr][nc]) cnt++;
                            }
                        }
                        arr[i][j] = cnt;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] == 0) {
                        count(arr, visited, i, j);
                        ans++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void count(int[][] arr, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int k = 0; k < 8; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr.length) {
                if (!visited[nr][nc] && arr[nr][nc] == 0) {
                    count(arr, visited, nr, nc);
                }
                visited[nr][nc] = true;
            }
        }
    }
}