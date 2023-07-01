import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] lan;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];
        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        long left = 1;
        long right = (long) Integer.MAX_VALUE + 1;
        while (right - left > 1) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    private static boolean check(long mid) {
        int result = 0;
        for (int i = 0; i < K; i++) {
            result += lan[i] / mid;
        }
        return result >= N;
    }
}