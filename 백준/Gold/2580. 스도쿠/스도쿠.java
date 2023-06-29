import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        List<Direction> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    list.add(new Direction(i, j));
                }
                arr[i][j] = num;
            }
        }
        for (Direction direction : list) {
            boolean[] visited = new boolean[10];
            int r = direction.r / 3 * 3;
            int c = direction.c / 3 * 3;
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    visited[arr[i][j]] = true;
                }
            }
            r = direction.r;
            c = direction.c;
            for (int i = 0; i < 9; i++) {
                visited[arr[r][i]] = true;
            }
            for (int i = 0; i < 9; i++) {
                visited[arr[i][c]] = true;
            }
            int a = 0;
            for (int i = 1; i < 10; i++) {
                if (!visited[i]) {
                    direction.list.add(i);
                }
            }
        }
        comb(arr, list, 0);
        System.out.println(sb);
    }

    private static boolean comb(int[][] arr, List<Direction> list, int idx) {
        if (!check(arr, list, idx)) {
            return false;
        }
        if (idx == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return true;
        }
        Direction dir = list.get(idx);
        for (int i : dir.list) {
            arr[dir.r][dir.c] = i;
            if (comb(arr, list, idx + 1)) {
                return true;
            }
            arr[dir.r][dir.c] = 0;
        }
        return false;
    }

    private static boolean check(int[][] arr, List<Direction> list, int idx) {
//        for (int i = 0; i < idx; i++) {
        if (idx == 0)
            return true;
        Direction dir = list.get(idx - 1);
        int r = dir.r;
        int c = dir.c;
        if (!squareCheck(arr, r, c)) {
            return false;
        }
        if (!rowCheck(arr, r)) {
            return false;
        }
        if (!colCheck(arr, c)) {
            return false;
        }
//        }
        return true;
    }

    private static boolean squareCheck(int[][] arr, int r, int c) {
        r = r / 3 * 3;
        c = c / 3 * 3;
        boolean[] visited = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (arr[i][j] != 0 && visited[arr[i][j]]) {
                    return false;
                }
                visited[arr[i][j]] = true;
            }
        }
        return true;
    }

    private static boolean rowCheck(int[][] arr, int r) {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (arr[r][i] != 0 && visited[arr[r][i]]) {
                return false;
            }
            visited[arr[r][i]] = true;
        }
        return true;
    }

    private static boolean colCheck(int[][] arr, int c) {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (arr[i][c] != 0 && visited[arr[i][c]]) {
                return false;
            }
            visited[arr[i][c]] = true;
        }
        return true;
    }

}

class Direction {
    int r;
    int c;
    List<Integer> list;

    public Direction(int r, int c) {
        this.r = r;
        this.c = c;
        this.list = new ArrayList<>();
    }
}
