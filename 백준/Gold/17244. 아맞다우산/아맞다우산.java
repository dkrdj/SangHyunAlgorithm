import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int startR = 0;
        int startC = 0;
        int endR = 0;
        int endC = 0;
        Map<Integer, Integer> xMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    xMap.put(i * 100 + j, 1 << cnt);
                    cnt++;
                } else if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (map[i][j] == 'E') {
                    endR = i;
                    endC = j;
                }
            }
        }
        boolean[][][] visited = new boolean[m][n][1 << cnt];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(startR, startC, 0, 0));
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.r == endR && node.c == endC && node.visited == (1 << cnt) - 1) {
                System.out.println(node.length);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && map[nr][nc] != '#') {
                    if (!visited[nr][nc][node.visited]) {
                        visited[nr][nc][node.visited] = true;
                        int visit = node.visited;
                        if (xMap.get(nr * 100 + nc) != null) {
                            int loc = xMap.get(nr * 100 + nc);
                            visit |= loc;
                        }
                        que.offer(new Node(nr, nc, node.length + 1, visit));
                    }
                }
            }
        }
    }
}

class Node {
    int r;
    int c;
    int length;
    int visited;

    public Node(int r, int c, int length, int visited) {
        this.r = r;
        this.c = c;
        this.length = length;
        this.visited = visited;
    }
}