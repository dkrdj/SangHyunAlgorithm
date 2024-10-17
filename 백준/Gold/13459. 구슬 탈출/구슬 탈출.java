import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] arr;
    static boolean isSuccess, tmp;
    static int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bur.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = bur.readLine().toCharArray();
        }
        int rr = 0, rc = 0, br = 0, bc = 0;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'R') {
                    rr = i;
                    rc = j;
                } else if (arr[i][j] == 'B') {
                    br = i;
                    bc = j;
                }
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(rr, rc, br, bc, 0));
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[rr][rc][br][bc] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            int cnt = node.cnt;
            if (cnt == 10) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nrr = node.rr + dr[i];
                int nrc = node.rc + dc[i];
                boolean wall = false;
                boolean redIn = false, blueIn = false;
                while (nrr >= 0 && nrc >= 0 && nrr < N && nrc < M) {
                    if (arr[nrr][nrc] == '#' || (nrr == node.br && nrc == node.bc)) {
                        wall = true;
                        break;
                    }
                    if (arr[nrr][nrc] == 'O') {
                        redIn = true;
                        break;
                    }
                    nrr += dr[i];
                    nrc += dc[i];
                }
                if (wall) {
                    nrr -= dr[i];
                    nrc -= dc[i];
                }
                int nbr = node.br + dr[i];
                int nbc = node.bc + dc[i];
                wall = false;
                while (nbr >= 0 && nbc >= 0 && nbr < N && nbc < M) {
                    if (arr[nbr][nbc] == '#' || (!redIn && (nbr == nrr && nbc == nrc))) {
                        wall = true;
                        break;
                    }
                    if (arr[nbr][nbc] == 'O') {
                        blueIn = true;
                        break;
                    }
                    nbr += dr[i];
                    nbc += dc[i];
                }
                if (wall) {
                    nbr -= dr[i];
                    nbc -= dc[i];
                }
                wall = false;
                while (nrr >= 0 && nrc >= 0 && nrr < N && nrc < M) {
                    if (arr[nrr][nrc] == '#' || (!blueIn && (nrr == nbr && nrc == nbc))) {
                        wall = true;
                        break;
                    }
                    if (arr[nrr][nrc] == 'O') {
                        redIn = true;
                        break;
                    }
                    nrr += dr[i];
                    nrc += dc[i];
                }
                if (wall) {
                    nrr -= dr[i];
                    nrc -= dc[i];
                }
                if (blueIn) {
                    continue;
                }
                if (redIn) {
                    isSuccess = true;
                    break;
                }

                if (!visited[nrr][nrc][nbr][nbc]) {
                    visited[nrr][nrc][nbr][nbc] = true;
                    que.offer(new Node(nrr, nrc, nbr, nbc, cnt + 1));
                }
            }
        }
        System.out.println(isSuccess ? 1 : 0);
    }

}

class Node {
    int rr;
    int rc;
    int br;
    int bc;
    int cnt;

    public Node(int rr, int rc, int br, int bc, int cnt) {
        this.rr = rr;
        this.rc = rc;
        this.br = br;
        this.bc = bc;
        this.cnt = cnt;
    }
}