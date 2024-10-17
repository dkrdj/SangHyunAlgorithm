import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = cArr[j] - '0';
            }
        }

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 0, 0));
        boolean[][][] visited = new boolean[N][M][K + 1];
        visited[0][0][0] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.r == N - 1 && node.c == M - 1) {
                System.out.println(node.dist + 1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visited[nr][nc][node.cnt]) {
                        if (arr[nr][nc] == 1) {
                            if (node.cnt < K) {
                                if (node.dist % 2 == 0) {
                                    visited[nr][nc][node.cnt] = true;
                                    que.offer(new Node(nr, nc, node.cnt + 1, node.dist + 1));
                                } else {
                                    que.offer(new Node(node.r, node.c, node.cnt, node.dist + 1));
                                }
                            }
                        } else {
                            visited[nr][nc][node.cnt] = true;
                            que.offer(new Node(nr, nc, node.cnt, node.dist + 1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

}

class Node {
    int r;
    int c;
    int cnt;
    int dist;

    public Node(int r, int c, int cnt, int dist) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.dist = dist;
    }
}