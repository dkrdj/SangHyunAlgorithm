import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, K;
    static Node[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Node[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }
        int max = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int x = arr[i].x;
                int y = arr[j].y;
                int dx = x + L;
                int dy = y + L;
                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    int tx = arr[k].x;
                    int ty = arr[k].y;
                    if (tx >= x && tx <= dx && ty >= y && ty <= dy) {
                        cnt++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(K - max);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}