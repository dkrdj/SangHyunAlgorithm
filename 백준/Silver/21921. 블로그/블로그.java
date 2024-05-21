import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }
        int[] result = new int[N];
        for (int i = 0; i < X; i++) {
            result[i] = arr[i];
        }
        for (int i = X; i < N; i++) {
            result[i] = arr[i] - arr[i - X];
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, result[i]);
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (max == result[i]) {
                cnt++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}