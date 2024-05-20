import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            int[] arr = new int[20];
            int count = 0;
            for (int j = 0; j < 20; j++) {
                int child = Integer.parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    if (arr[k] > child) {
                        count++;
                    }
                }
                arr[j] = child;
            }
            sb.append(count).append(" ").append("\n");
        }
        System.out.println(sb);
    }
}