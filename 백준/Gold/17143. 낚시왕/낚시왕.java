import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, M;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};
    static Shark[] sharks;
    static boolean[] alive;
    static int[][] map, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        arr = new int[R][C];
        sharks = new Shark[10001];
        alive = new boolean[10001];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            sharks[z] = new Shark(r, c, s, d, z);
            alive[z] = true;
            map[r][c] = z;
            arr[r][c] = i;
        }
        int ans = 0;
        for (int i = 0; i < C; i++) {
            ans += getShark(i);
            map = new int[R][C];
            for (int j = 1; j <= 10000; j++) {
                if (alive[j]) {
                    Shark shark = sharks[j];
                    shark.move();
                    if (map[shark.r][shark.c] == 0) {
                        arr[shark.r][shark.c] = j;
                        map[shark.r][shark.c] = shark.size;
                    } else {
                        if (shark.size > sharks[arr[shark.r][shark.c]].size) {
                            arr[shark.r][shark.c] = j;
                            alive[map[shark.r][shark.c]] = false;
                            map[shark.r][shark.c] = shark.size;
                        } else {
                            alive[shark.size] = false;
                        }
                    }
                }
            }
        }

        System.out.println(ans);


    }


    static int getShark(int c) {
        for (int i = 0; i < R; i++) {
            if (map[i][c] != 0) {
                alive[map[i][c]] = false;
                return map[i][c];
            }
        }
        return 0;
    }

    static class Shark {
        int r, c, speed, dir, size;

        public Shark(int r, int c, int speed, int dir, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        void move() {
            r = (r + speed * dr[dir]) % (2 * (R - 1));
            c = (c + speed * dc[dir]) % (2 * (C - 1));
            if (r < 0) {
                r = Math.abs(r);
                if (dir == 1) dir = 0;
                else dir = 1;
            } else if (c < 0) {
                c = Math.abs(c);
                if (dir == 2) dir = 3;
                else dir = 2;
            }
            if (r >= R) {
                r = 2 * (R - 1) - r;
                if (dir == 1) dir = 0;
                else dir = 1;
            } else if (c >= C) {
                c = 2 * (C - 1) - c;
                if (dir == 2) dir = 3;
                else dir = 2;
            }
        }
    }
}

