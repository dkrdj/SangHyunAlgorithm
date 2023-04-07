import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    cnt++;
                    for (int ii = 0; ii <= i; ii++) {
                        for (int jj = 0; jj <= j; jj++) {
                            if (ii == i && jj == j) continue;
                            arr[ii][jj] = 1 - arr[ii][jj];
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}