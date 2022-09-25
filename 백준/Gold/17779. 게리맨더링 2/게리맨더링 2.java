import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, sum, ans = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                for (int d1 = 1; j - d1 >= 0; d1++) {
                    for (int d2 = 1; j + d2 < N && i + d1 + d2 < N; d2++) {
                        garry(i, j, d1, d2);
                    }
                }
            }
        }
        System.out.println(ans);

    }

    private static void garry(int x, int y, int d1, int d2) {
        int[] arr = new int[5];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j <= x + d1; j++) {
                arr[0] += map[i][j];
            }
        }
        for (int i = y - d1, cnt = 0; i < y; i++, cnt++) {
            for (int j = x + d1 - cnt; j <= x + d1; j++) {
                arr[0] -= map[i][j];
            }
        }

        for (int i = 0; i <= y - d1 + d2; i++) {
            for (int j = x + d1 + 1; j < N; j++) {
                arr[1] += map[i][j];
            }
        }
        for (int i = y - d1 + 1, cnt = 0; i <= y - d1 + d2; i++, cnt++) {
            for (int j = x + d1 + 1; j <= x + d1 + 1 + cnt; j++) {
                arr[1] -= map[i][j];
            }
        }

        for (int i = y; i < N; i++) {
            for (int j = 0; j < x + d2; j++) {
                arr[2] += map[i][j];
            }
        }
        for (int i = y, cnt = 0; i <= y + d2; i++, cnt++) {
            for (int j = x + cnt; j < x + d2; j++) {
                arr[2] -= map[i][j];
            }
        }

        for (int i = y - d1 + d2 + 1; i < N; i++) {
            for (int j = x + d2; j < N; j++) {
                arr[3] += map[i][j];
            }
        }
        for (int i = y - d1 + d2 + 1, cnt = 0; i < N; i++, cnt++) {
            for (int j = x + d2; j < x + d1 + d2 - cnt; j++) {
                arr[3] -= map[i][j];
            }
        }
        arr[4] = sum - arr[0] - arr[1] - arr[2] - arr[3];
        Arrays.sort(arr);
        ans = Math.min(ans, arr[4] - arr[0]);
    }
}
