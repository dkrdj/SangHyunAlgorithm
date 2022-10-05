import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static List<Matrix> list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] != 0) {
                        findMatrix(i, j);
                    }
                }
            }
            list.sort((o1, o2) -> {
                if (o1.r * o1.c == o2.r * o2.c) {
                    return o1.r - o2.r;
                }
                return o1.r * o1.c - o2.r * o2.c;
            });
            sb.append("#").append(t).append(" ").append(list.size()).append(" ");
            for (Matrix mtx : list) {
                int r = mtx.r;
                int c = mtx.c;
                sb.append(r).append(" ").append(c).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void findMatrix(int r, int c) {
        int nr = r;
        int nc = c;
        while (nr + 1 < N && arr[nr + 1][nc] != 0) {
            nr++;
        }
        while (nc + 1 < N && arr[nr][nc + 1] != 0) {
            nc++;
        }
        for (int i = r; i <= nr; i++) {
            for (int j = c; j <= nc; j++) {
                visited[i][j] = true;
            }
        }
        list.add(new Matrix(nr - r + 1, nc - c + 1));
    }

    private static class Matrix {
        int r;
        int c;

        public Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

