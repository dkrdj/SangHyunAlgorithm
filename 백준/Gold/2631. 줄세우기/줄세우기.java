import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] lis = new int[N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > lis[idx]) {
                lis[++idx] = arr[i];
            } else {
                setArr(arr, lis, idx, i);
            }
        }
        System.out.println(N - idx);
    }

    private static void setArr(int[] arr, int[] lis, int idx, int arrIdx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (arr[arrIdx] > lis[i]) {
                lis[i + 1] = arr[arrIdx];
                break;
            }
        }
    }
}