import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, sr, sc, er, ec;
    static int[][] arr;
    static int[] dc = {1, -1, 0, 0}, dr = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (c[j] == '#') arr[i][j] = -1;
            }
        }
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(sr, sc));
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (curNode.r == er && curNode.c == ec) {
                return arr[er][ec];
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    int nr = curNode.r + j * dr[i];
                    int nc = curNode.c + j * dc[i];
                    if (nr < N && nr >= 0 && nc >= 0 && nc < M) {
                        if (arr[nr][nc] == -1) {
                            break;
                        } else if (j == 1 && arr[nr][nc] != 0 && arr[nr][nc] <= arr[curNode.r][curNode.c]) {
                            break;
                        } else if (arr[nr][nc] == 0) {
                            arr[nr][nc] = arr[curNode.r][curNode.c] + 1;
                            que.offer(new Node(nr, nc));
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;

    }
}

class Node {
    int r;
    int c;


    public Node(int r, int c) {
        this.r = r;
        this.c = c;

    }

}