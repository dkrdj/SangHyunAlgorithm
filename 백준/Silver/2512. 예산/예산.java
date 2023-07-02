import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        M = Integer.parseInt(br.readLine());
        int left = 1;
        int right = max + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    private static boolean check(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++)
            sum += Math.min(arr[i], mid);
        return sum <= M;
    }
}