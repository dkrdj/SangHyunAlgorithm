import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int x = arr[i].x;
                int y = arr[j].y;
                if (x == 2 && y == 2) {
                    int a = 0;
                }
                for (int l = 1; l < I / 2; l++) {
                    int dx = x + l;
                    int dy = y + I / 2 - l;
                    int cnt = 0;
                    for (int k = 0; k < M; k++) {
                        int tx = arr[k].x;
                        int ty = arr[k].y;
                        if (tx >= x && tx <= dx && ty >= y && ty <= dy) {
                            cnt++;
                        }
                    }
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
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