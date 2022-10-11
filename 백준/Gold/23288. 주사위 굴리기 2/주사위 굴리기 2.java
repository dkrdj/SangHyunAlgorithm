import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, ans;
    static int[][] arr;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; // 동 남 서 북
    static Dice dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            dice.move();
        }
        System.out.println(ans);
    }

    private static class Dice {
        int top, up, right, left, down, bottom;
        int dir;
        int r, c;

        public Dice() {
            top = 1;
            up = 2;
            right = 3;
            left = 4;
            down = 5;
            bottom = 6;
            dir = 0;
            r = 0;
            c = 0;
        }

        public void move() {
            r += dr[dir];
            if (r < 0 || r >= N) {
                r -= 2 * dr[dir];
                dir = (dir + 2) % 4;
            }
            c += dc[dir];
            if (c < 0 || c >= M) {
                c -= 2 * dc[dir];
                dir = (dir + 2) % 4;
            }
            int tmp = bottom;
            switch (dir) {
                case 0:
                    bottom = right;
                    right = top;
                    top = left;
                    left = tmp;
                    break;
                case 1:
                    bottom = down;
                    down = top;
                    top = up;
                    up = tmp;
                    break;
                case 2:
                    bottom = left;
                    left = top;
                    top = right;
                    right = tmp;
                    break;
                case 3:
                    bottom = up;
                    up = top;
                    top = down;
                    down = tmp;
                    break;
            }

            if (bottom > arr[r][c]) {
                dir = (dir + 1) % 4;
            } else if (bottom < arr[r][c]) {
                dir = (dir + 3) % 4;
            }
            getAnswer();
        }

        public void getAnswer() {
            boolean[][] visited = new boolean[N][M];
            Queue<Node> que = new LinkedList<>();
            visited[r][c] = true;
            que.offer(new Node(r, c));
            int cnt = 0;
            while (!que.isEmpty()) {
                Node curNode = que.poll();
                cnt++;
                for (int i = 0; i < 4; i++) {
                    int nr = curNode.r + dr[i];
                    int nc = curNode.c + dc[i];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (!visited[nr][nc] && arr[nr][nc] == arr[r][c]) {
                            visited[nr][nc] = true;
                            que.offer(new Node(nr, nc));
                        }
                    }
                }
            }
            ans += arr[r][c] * cnt;
        }

    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}