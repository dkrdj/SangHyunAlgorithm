import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[5][5];
        backtrack(0, visited, 0);
        System.out.println(answer);
    }

    private static void backtrack(int idx, boolean[][] visited, int cnt) {
        if (cnt == 7) {
            if (check(visited)) {
                answer++;
            }
            return;
        }
        for (int i = idx / 5; i < 5; i++) {
            if (i == idx / 5)
                for (int j = idx % 5; j < 5; j++) {
                    visited[i][j] = true;
                    backtrack(i * 5 + j + 1, visited, cnt + 1);
                    visited[i][j] = false;
                }
            else {
                for (int j = 0; j < 5; j++) {
                    visited[i][j] = true;
                    backtrack(i * 5 + j + 1, visited, cnt + 1);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static boolean check(boolean[][] map) {
        int startR = 0;
        int startC = 0;
        int sCount = 0;
        int yCount = 0;
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j]) {
                    startR = i;
                    startC = j;
                    break outer;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j]) {
                    if (arr[i][j] == 'Y') {
                        yCount++;
                    } else {
                        sCount++;
                    }
                }
            }
        }
        if (yCount >= 4) {
            return false;
        }
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (!map[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return cnt == 7;
    }

}