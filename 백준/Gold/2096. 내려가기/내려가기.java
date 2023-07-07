import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] max = new int[n + 1][3];
        int[][] min = new int[n + 1][3];
        max[1][0] = arr[1][0];
        max[1][1] = arr[1][1];
        max[1][2] = arr[1][2];
        min[1][0] = arr[1][0];
        min[1][1] = arr[1][1];
        min[1][2] = arr[1][2];
        for (int i = 2; i <= n; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];
            max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + arr[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][2];
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];
            min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + arr[i][1];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][2];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(max[n][0], Math.max(max[n][1], max[n][2]))).append(" ").append(Math.min(min[n][0], Math.min(min[n][1], min[n][2])));
        System.out.println(sb);
    }

}