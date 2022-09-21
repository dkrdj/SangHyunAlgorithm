import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dcx, dcy;
    static int N, ans;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[101][101];
        dcx = new int[(1 << 11) + 1];
        dcy = new int[(1 << 11) + 1];

        dragonCurb();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            draw(x, y, d, g);
        }

        check();
        System.out.println(ans);
    }

    static void check() {
        for (int i = 0; i < 100; i++) {
            inner:
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 1][j + 1] == 1 && arr[i][j + 1] == 1) {
                    ans++;
                }
            }
        }
    }

    static void draw(int x, int y, int d, int g) {
        if (d == 0) {
            for (int i = 0; i <= (1 << g); i++) {
                arr[x + dcx[i]][y - dcy[i]] = 1;
            }
        } else if (d == 1) {
            for (int i = 0; i <= (1 << g); i++) {
                arr[x - dcy[i]][y - dcx[i]] = 1;
            }
        } else if (d == 2) {
            for (int i = 0; i <= (1 << g); i++) {
                arr[x - dcx[i]][y + dcy[i]] = 1;
            }
        } else {
            for (int i = 0; i <= (1 << g); i++) {
                arr[x + dcy[i]][y + dcx[i]] = 1;
            }
        }
    }

    static void dragonCurb() {

        dcx[1] = 1;
        dcy[1] = 0;
        for (int i = 0; i <= 10; i++)
            for (int j = 1; j <= (1 << i); j++) {
                dcx[(1 << i) + j] = dcx[(1 << i)] - dcy[(1 << i)] + dcy[(1 << i) - j];
                dcy[(1 << i) + j] = dcy[(1 << i)] + dcx[(1 << i)] - dcx[(1 << i) - j];
            }
    }

}