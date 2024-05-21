import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());
        int max = cur;

        for (int i = 1; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            int dist = x - cur;
            if (dist % 2 == 0) {
                dist /= 2;
            } else {
                dist = dist / 2 + 1;
            }
            max = Math.max(max, dist);
            cur = x;
        }
        max = Math.max(max, N - cur);
        System.out.println(max);
    }
}