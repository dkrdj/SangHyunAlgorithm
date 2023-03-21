import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                System.out.println(sb);
                return;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(arr, 0, 0, new int[6]);
            sb.append("\n");
        }
    }

    private static void comb(int[] arr, int idx, int sidx, int[] res) {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = sidx; i < arr.length && arr.length - i + idx >= 6; i++) {
            res[idx] = arr[i];
            comb(arr, idx + 1, i + 1, res);
        }
    }

}

