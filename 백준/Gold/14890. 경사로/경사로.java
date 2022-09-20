import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, ans;
    static int[][] map;
    static boolean[] stair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check();
        System.out.println(ans);

    }

    static boolean up(int start, boolean dir, int idx) { // true = row, false = col, idx = 지점
        if (start - L < 0) return true;
        if (stair[start - 1]) return true;
        if (dir) {
            for (int i = start - 1; i > start - L; i--) {
                if (map[idx][i] != map[idx][i - 1] || stair[i - 1])
                    return true;
                stair[i - 1] = true;
            }
        } else {
            for (int i = start - 1; i > start - L; i--) {
                if (map[i][idx] != map[i - 1][idx] || stair[i - 1])
                    return true;
                stair[i - 1] = true;
            }
        }
        return false;
    }

    static boolean down(int start, boolean dir, int idx) {
        if (start + L - 1 >= N) return true;
        if (stair[start]) return true;
        stair[start] = true;
        if (dir) {
            for (int i = start; i < start + L - 1; i++) {
                if (map[idx][i] != map[idx][i + 1] || stair[i + 1])
                    return true;
                stair[i + 1] = true;
            }
        } else {
            for (int i = start; i < start + L - 1; i++) {
                if (map[i][idx] != map[i + 1][idx] || stair[i + 1])
                    return true;
                stair[i + 1] = true;
            }
        }
        return false;
    }

    static void check() {
        //가로줄 검사
        outer:
        for (int i = 0; i < N; i++) {
            stair = new boolean[N];
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1] + 1) {
                    if (down(j + 1, true, i)) {
                        continue outer;
                    }
                } else if (map[i][j] == map[i][j + 1] - 1) {
                    if (up(j + 1, true, i)) {
                        continue outer;
                    }
                } else if (map[i][j] != map[i][j + 1]) {
                    continue outer;
                }
            }
            ans++;
        }
        //세로줄 검사
        outer:
        for (int i = 0; i < N; i++) {
            stair = new boolean[N];
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i] + 1) {
                    if (down(j + 1, false, i)) {
                        continue outer;
                    }
                } else if (map[j][i] == map[j + 1][i] - 1) {
                    if (up(j + 1, false, i)) {
                        continue outer;
                    }
                } else if (map[j][i] != map[j + 1][i]) {
                    continue outer;
                }
            }
            ans++;
        }
    }
}
