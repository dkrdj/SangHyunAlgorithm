import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 0 북 1 동 2 남 3 서
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f1(R, C, d);
        System.out.println(ans);
    }

    static void f1(int R, int C, int d) {
        ans++;
        map[R][C] = 2;
        f2(R, C, d);
    }

    static void f2(int R, int C, int d) {
        boolean isWall = false;
        boolean isDirty = false;
        int nd = d;
        for (int i = 0; i < 4; i++) {
            nd = (nd + 3) % 4;
            int nr = R + dr[nd];
            int nc = C + dc[nd];
            if (map[nr][nc] == 0) {
                R = nr;
                C = nc;
                d = nd;
                isDirty = true;
                break;
            }
        }
        if (isDirty) {
            f1(R, C, d);
        } else {
            R -= dr[d];
            C -= dc[d];
            if (R < 0 || R >= N || C < 0 || C >= M || map[R][C] == 1)
                return;
            else
                f2(R, C, d);
        }
    }

}
