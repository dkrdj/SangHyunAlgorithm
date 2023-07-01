import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }
        int rest = n;
        int answer = 0;
        for (int i = 1; i <= 10000; i++) {
            if (arr[i] != 0) {
                answer = Math.max(answer, i * rest);
                rest -= arr[i];
            }
        }
        System.out.println(answer);
    }
}