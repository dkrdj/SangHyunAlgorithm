import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[N];
        res[0] = arr[0];
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > res[cnt]) {
                res[++cnt] = arr[i];
            } else {
                res[binarySearch(arr[i], res, 0, cnt)] = arr[i];
            }
        }
        System.out.println(cnt + 1);
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