import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            arr[i] = new Node(x, y);
        }
        arr[N] = new Node(arr[0].x, arr[0].y);
        long sum_p = 0L;
        long sum_m = 0L;
        for (int i = 0; i < N; i++) {
            sum_p += arr[i].x * arr[i + 1].y;
            sum_m += arr[i + 1].x * arr[i].y;
        }
        double sum = Math.abs((sum_p - sum_m) / 2.0);
        System.out.printf("%.1f", (Math.round(sum * 10) / 10.0));
    }
}

class Node {
    long x;
    long y;

    public Node(long x, long y) {
        this.x = x;
        this.y = y;
    }
}