import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 1;
        while (b > a) {
            if (b % 2 == 0) {
                b = b / 2;
                answer++;
            } else if (b - b / 10 * 10 == 1) {
                b = b / 10;
                answer++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        if (a != b) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}
