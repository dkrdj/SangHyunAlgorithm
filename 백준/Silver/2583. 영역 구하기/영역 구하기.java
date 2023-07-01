import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int N, M, K;
    static List<Integer> list;
    static int count;
    static int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        count = 0;
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0)
                    bfs(i, j);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        Collections.sort(list);
        for (int answer : list) {
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int startR, int startC) {
        count++;
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(startR, startC));
        arr[startR][startC] = 1;
        int result = 1;
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M)
                    if (arr[nr][nc] == 0) {
                        arr[nr][nc] = 1;
                        result++;
                        que.offer(new Node(nr, nc));
                    }
            }
        }
        list.add(result);
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