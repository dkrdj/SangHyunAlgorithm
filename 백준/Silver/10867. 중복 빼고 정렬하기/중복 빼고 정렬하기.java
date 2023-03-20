import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Long, Boolean> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[2001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num + 1000]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(i - 1000).append(" ");
            }
        }
        System.out.println(sb);

    }

}

