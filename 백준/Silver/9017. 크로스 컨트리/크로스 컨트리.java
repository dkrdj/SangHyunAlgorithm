import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cntArr = new int[201];
            int[] arr = new int[N];
            int[] scores = new int[201];
            int[] restArr = new int[201];
            int[] fifth = new int[201];
            for (int i = 0; i < N; i++) {
                int score = Integer.parseInt(st.nextToken());
                cntArr[score]++;
                restArr[score]++;
                arr[i] = score;
            }
            for (int i = 0, j = 1; i < N; i++) {
                int team = arr[i];
                if (cntArr[team] == 6) {
                    if (restArr[team] > 2) {
                        scores[team] += j;
                    }
                    if (restArr[team] == 2) {
                        fifth[team] = j;
                    }
                    restArr[team]--;
                    j++;
                }
            }
            int min = Integer.MAX_VALUE;
            int winner = -1;
            for (int i = 1; i <= 200; i++) {
                if (cntArr[i] == 6 && min > scores[i]) {
                    winner = i;
                    min = scores[i];
                }
            }

            for (int i = 1; i <= 200; i++) {
                if (cntArr[i] == 6 && min == scores[i] && fifth[i] < fifth[winner]) {
                    winner = i;
                }
            }
            System.out.println(winner);
        }
    }
}