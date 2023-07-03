import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 1000000001;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (check(mid))
                left = mid;
            else right = mid;

        }
        System.out.println(left);
    }

    private static boolean check(int mid) {
        int count = 1;
        int before = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] - before >= mid) {
                before = arr[i];
                if (++count == C)
                    return true;
            }
        }
        return false;
    }

}
