import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static List<Node> virus = new ArrayList<>();
    static int N, M, full, ans = 10000;
    static int[] res, dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        res = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Node(i, j));
                } else if (map[i][j] == 0) full++;
            }
        }

        comb(0, 0, 0);
        System.out.println(ans == 10000 ? -1 : ans);
    }

    private static void comb(int idx, int sidx, int visited) {
        if (sidx == M) {
            bfs();
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            if ((visited & (1 << i)) == 0) {
                res[sidx] = i;
                comb(i + 1, sidx + 1, visited | (1 << i));
            }
        }
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            Node node = virus.get(res[i]);
            visited[node.r][node.c] = true;
            que.offer(node);
        }
        int cost = 0;
        int cnt = 0;
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (map[curNode.r][curNode.c] == 0) {
                cost = curNode.cost;
                cnt++;
            }
            if (cost >= ans) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (!visited[nr][nc] && map[nr][nc] != 1) {
                        visited[nr][nc] = true;
                        que.offer(new Node(nr, nc, curNode.cost + 1));
                    }
                }
            }
        }
        if (cnt == full)
            ans = Math.min(ans, cost);

    }
}

class Node {
    int r;
    int c;
    int cost;

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
