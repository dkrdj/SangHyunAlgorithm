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
        int[] max = new int[3];
        int[] min = new int[3];
        max[0] = arr[1][0];
        max[1] = arr[1][1];
        max[2] = arr[1][2];
        min[0] = arr[1][0];
        min[1] = arr[1][1];
        min[2] = arr[1][2];
        int preMax0, preMax1, preMax2, preMin0, preMin1, preMin2;
        for (int i = 2; i <= n; i++) {
            preMax0 = max[0];
            preMax1 = max[1];
            preMax2 = max[2];
            preMin0 = min[0];
            preMin1 = min[1];
            preMin2 = min[2];
            max[0] = Math.max(preMax0, preMax1) + arr[i][0];
            max[1] = Math.max(preMax0, Math.max(preMax1, preMax2)) + arr[i][1];
            max[2] = Math.max(preMax1, preMax2) + arr[i][2];
            min[0] = Math.min(preMin0, preMin1) + arr[i][0];
            min[1] = Math.min(preMin0, Math.min(preMin1, preMin2)) + arr[i][1];
            min[2] = Math.min(preMin1, preMin2) + arr[i][2];
        }
        System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
    }
}