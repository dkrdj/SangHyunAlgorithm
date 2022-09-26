import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static List<Integer>[][] num;
    static Piece[] pieces;
    static int N, K;

    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        num = new LinkedList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num[i][j] = new LinkedList<>();
            }
        }
        pieces = new Piece[K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            pieces[i] = new Piece(r, c, dir);
            num[r][c].add(i);
        }
        for (int t = 1; t <= 1000; t++) {
            for (int i = 1; i <= K; i++) {
                move(pieces[i], false);
                if (num[pieces[i].r][pieces[i].c].size() >= 4) {
                    System.out.println(t);
                    return;
                }
            }
        }
        System.out.println(-1);

    }

    private static void move(Piece piece, boolean flag) {
        List<Integer> list = num[piece.r][piece.c];
        int beforeFloor = piece.floor;
        int nr = piece.r + dr[piece.dir];
        int nc = piece.c + dc[piece.dir];
        if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
            if (!flag) {
                if (piece.dir == 0) piece.dir = 1;
                else if (piece.dir == 1) piece.dir = 0;
                else if (piece.dir == 2) piece.dir = 3;
                else piece.dir = 2;
                move(piece, true);
            }
        } else if (map[nr][nc] == 1) {
            Stack<Integer> stack = new Stack<>();
            for (int i = beforeFloor; i < list.size(); i++) {
                stack.push(list.get(i));
            }
            while (!stack.isEmpty()) {
                int nxtIdx = stack.pop();
                Piece nxtPiece = pieces[nxtIdx];
                nxtPiece.r = nr;
                nxtPiece.c = nc;
                nxtPiece.floor = num[nr][nc].size();
                num[nr][nc].add(nxtIdx);
            }
            while (list.size() > beforeFloor) {
                list.remove(list.size() - 1);
            }
        } else {
            for (int i = piece.floor; i < list.size(); i++) {
                Piece nxtPiece = pieces[list.get(i)];
                nxtPiece.r = nr;
                nxtPiece.c = nc;
                nxtPiece.floor = num[nr][nc].size();
                num[nr][nc].add(list.get(i));
            }
            while (list.size() > beforeFloor) {
                list.remove(list.size() - 1);
            }
        }

    }


    static class Piece {
        int r;
        int c;
        int dir;
        int floor;

        public Piece(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;

        }
    }
}

