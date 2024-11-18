import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, p;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = 1;
        answer = new int[10];
        while (n > 0) {
            while (n % 10 != 9 && n > 0) {
                calc(n);
                n--;
            }
            for (int i = 1; i <= 9 && n >= i; i++) {
                answer[i] += p;
            }
            if (n <= 0) {
                break;
            }
            n /= 10;
            for (int i = 0; i <= 9; i++) {
                answer[i] += p * n;
            }
            p *= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }

    private static void calc(int num) {
        while (num != 0) {
            answer[num % 10] += p;
            num /= 10;
        }
    }
}
