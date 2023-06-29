import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] arr;
    static int col, row, count, max;

    private static void bfs() {
        Queue<Cheese> que = new LinkedList<>();
        Set<Cheese> set = new HashSet<>();
        boolean[][] visited = new boolean[row][col];
        que.offer(new Cheese(0, 0));
        int tmpCount = 0;
        while (!que.isEmpty()) {
            Cheese curCheese = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curCheese.r + dr[i];
                int nc = curCheese.c + dc[i];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        if (arr[nr][nc] == 0) {
                            que.offer(new Cheese(nr, nc));
                        } else if (arr[nr][nc] == 1) {
                            tmpCount++;
                            set.add(new Cheese(nr, nc));
                        }
                    }
                }
            }
        }
        for (Cheese cheese : set) {
            arr[cheese.r][cheese.c] = 0;
        }
        if (tmpCount != 0) {
            count = tmpCount;
            max++;
            bfs();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(max);
        System.out.println(count);
    }
}

class Cheese {
    int r;
    int c;

    public Cheese(int r, int c) {
        this.r = r;
        this.c = c;
    }
}