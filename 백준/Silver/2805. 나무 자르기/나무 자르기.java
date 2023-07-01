import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 1000000000;
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
        long result = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > mid) {
                result += trees[i] - mid;
                if (result >= M)
                    return true;
            }
        }
        return false;
    }
}