import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, oper, res;
    static int N, start, ans, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N - 1];
        res = new int[N - 1];
        start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        oper = new int[4]; // + - * / 순서
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        permu(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void permu(int idx) {
        if (idx == N - 1) {
            calc(res);
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] != 0) {
                res[idx] = i;
                oper[i]--;
                permu(idx + 1);
                oper[i]++;
            }
        }
    }

    private static void calc(int[] res) {
        ans = start;
        for (int i = 0; i < N - 1; i++) {
            switch (res[i]) {
                case 0:
                    ans += arr[i];
                    break;
                case 1:
                    ans -= arr[i];
                    break;
                case 2:
                    ans *= arr[i];
                    break;
                case 3:
                    ans /= arr[i];
                    break;
                default:
                    break;
            }
        }
    }


}