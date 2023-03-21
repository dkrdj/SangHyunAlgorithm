import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        permu(new int[n], 0);
        System.out.println(sb);
    }

    private static boolean permu(int[] arr, int idx) {
        for (int i = 1; i <= idx / 2; i++) {
            if (check(arr, idx - 1, i))
                return false;
        }
        if (arr.length == idx) {
            for (int num : arr) {
                sb.append(num);
            }
            return true;
        }
        for (int i = 1; i <= 3; i++) {
            arr[idx] = i;
            if (permu(arr, idx + 1))
                return true;
        }
        return false;
    }

    private static boolean check(int[] arr, int idx, int size) {
        for (int i = idx; i > idx - size; i--) {
            if (arr[i] != arr[i - size]) {
                return false;
            }
        }
        return true;
    }

}
