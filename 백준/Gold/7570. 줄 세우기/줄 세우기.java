import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tmp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            tmp[a] = tmp[a - 1] + 1;
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, tmp[i]);
        }
        System.out.println(N - max);
    }
}