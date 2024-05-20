import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 3n(n+1)
        int count = 0;
        while (true) {
            int max = 3 * count * (count + 1) + 1;
            if (max >= N) {
                System.out.println(count + 1);
                return;
            }
            count++;
        }
    }
}