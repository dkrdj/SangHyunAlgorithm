import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println("A");
            return;
        }

        if (N == 2) {
            if (arr[0] == arr[1]) {
                System.out.println(arr[0]);
                return;
            }
            System.out.println("A");
            return;
        }
        if (arr[0] == arr[1]) {
            boolean isSame = true;
            for (int i = 2; i < N; i++) {
                if (arr[i] != arr[0]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                System.out.println(arr[0]);
                return;
            }
            System.out.println("B");
            return;
        }
        if ((arr[2] - arr[1]) % (arr[1] - arr[0]) != 0) {
            System.out.println("B");
            return;
        }
        int a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
        int b = arr[1] - a * arr[0];

        boolean isAnswer = true;
        for (int i = 3; i < N; i++) {
            if (a * arr[i - 1] + b != arr[i]) {
                isAnswer = false;
                break;
            }
        }
        if (isAnswer) {
            System.out.println(a * arr[N - 1] + b);
            return;
        }
        System.out.println("B");
    }
}