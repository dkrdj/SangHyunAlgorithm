import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];
        star(arr, 0, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] ? '*' : ' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(boolean[][] arr, int startR, int startC, int p) {
        if (p == 1)
            return;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (p == 3)
                    arr[startR + i][startC + j] = true;
                star(arr, startR + p / 3 * i, startC + p / 3 * j, p / 3);
            }
        }
    }
}