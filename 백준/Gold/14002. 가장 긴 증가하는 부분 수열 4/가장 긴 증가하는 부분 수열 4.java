import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[N];
        int[] K = new int[N];
        res[0] = arr[0];
        K[0] = 0;
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > res[cnt]) {
                res[++cnt] = arr[i];
                K[i] = cnt;
            } else {
                int idx = binarySearch(arr[i], res, 0, cnt);
                res[idx] = arr[i];
                K[i] = idx;
            }
        }
        sb.append(cnt + 1).append("\n");

        int[] ans = new int[cnt + 1];
        for (int i = N - 1; i >= 0; i--) {
            if (K[i] == cnt) {
                ans[cnt--] = arr[i];
            }
        }
        for (int num : ans) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int n, int[] res, int left, int right) {
        if (left >= right) {
            return right;
        } else {
            int mid = (left + right) / 2;
            if (n > res[mid]) {
                return binarySearch(n, res, mid + 1, right);
            } else {
                return binarySearch(n, res, left, mid);
            }
        }
    }
}