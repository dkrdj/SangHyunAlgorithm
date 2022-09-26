import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }

    private static void comb(int idx, int sidx, int visited) {
        if (sidx == N / 2) {
            calc(visited);
            return;
        }
        for (int i = idx; i < N; i++) {
            if ((visited & (1 << i)) == 0) {
                comb(i + 1, sidx + 1, visited | (1 << i));
            }
        }

    }

    private static void calc(int visited) {
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0) {
                team1.add(i);
            } else {
                team2.add(i);
            }
        }
        int abil1 = 0;
        for (int num1 : team1) {
            for (int num2 : team1) {
                abil1 += arr[num1][num2];
            }
        }
        int abil2 = 0;
        for (int num1 : team2) {
            for (int num2 : team2) {
                abil2 += arr[num1][num2];
            }
        }
        ans = Math.min(ans, Math.abs(abil1 - abil2));
    }
}