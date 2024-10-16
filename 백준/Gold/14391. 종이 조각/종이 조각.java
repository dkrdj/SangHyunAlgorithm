import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static String[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = String.valueOf(cArr[j]);
            }
        }
        visited[0][0] = true;
        backTracking(0, 0, null, 0, "");
        System.out.println(max);
    }

    public static void stop(int sum) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    backTracking(i, j, null, sum, "");
                    visited[i][j] = false;
                    return;
                }
            }
        }
    }

    public static boolean allVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void backTracking(int r, int c, int[] direction, int sum, String s) {
        s += arr[r][c];
        if (allVisited()) {
            max = Math.max(max, sum + Integer.parseInt(s));
            return;
        }
        stop(sum + Integer.parseInt(s));

        if (direction == null) {
            if (r + 1 < N && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                backTracking(r + 1, c, new int[]{1, 0}, sum, s);
                visited[r + 1][c] = false;
            }
            if (c + 1 < M && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                backTracking(r, c + 1, new int[]{0, 1}, sum, s);
                visited[r][c + 1] = false;
            }
        } else {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (nr < N && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                backTracking(nr, nc, direction, sum, s);
                visited[nr][nc] = false;
            }
        }
    }
}