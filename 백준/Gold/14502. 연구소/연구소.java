import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Node(i, j));
                }
            }
        }
        setWall(0);
        System.out.println(ans);

    }

    static void setWall(int count) {
        if (count == 3) {
            ans = Math.max(ans, safe());
            initMap();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(count + 1);
                    map[i][j] = 0;
                }

            }
        }
    }

    static void initMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 3)
                    map[i][j] = 0;
            }
        }
    }

    static int safe() {
        Queue<Node> que = new LinkedList<>();
        for (Node node : list) {
            que.offer(node);
        }
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = 3;
                        que.offer(new Node(nr, nc));
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    count++;
            }
        }
        return count;
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
