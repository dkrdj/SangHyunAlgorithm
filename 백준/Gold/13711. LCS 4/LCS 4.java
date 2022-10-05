import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N + 1];
        int[] arr2 = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            arr1[idx] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            arr2[i] = arr1[idx];
        }
        int[] res = new int[N + 1];
        res[1] = arr2[1];
        int cnt = 1;
        for (int i = 2; i <= N; i++) {
            if (arr2[i] > res[cnt]) {
                res[++cnt] = arr2[i];
            } else {
                res[binarySearch(res, arr2[i], 0, cnt)] = arr2[i];
            }
        }
        System.out.println(cnt);
    }// main

    private static int binarySearch(int[] res, int n, int left, int right) {
        if (left >= right) {
            return right;
        } else {
            int mid = (left + right) / 2;
            if (res[mid] < n) {
                return binarySearch(res, n, mid + 1, right);
            } else {
                return binarySearch(res, n, left, mid);
            }
        }
    }

}