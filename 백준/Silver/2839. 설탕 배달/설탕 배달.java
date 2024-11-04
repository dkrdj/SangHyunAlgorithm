import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int five = N / 5;
        int left = N % 5;
        while (five >= 0 && left % 3 > 0) {
            left += 5;
            five--;
        }
        if (five >= 0 && left % 3 == 0) {
            System.out.println(five + left / 3);
        } else {
            System.out.println(-1);
        }
    }
}
