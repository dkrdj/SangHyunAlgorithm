import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] gear;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new char[4][8];
        for (int i = 0; i < 4; i++) {
            gear[i] = br.readLine().toCharArray();
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new boolean[4];
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            rot(idx, dir);
        }
        System.out.println((gear[0][0] - '0') + (gear[1][0] - '0') * 2 + (gear[2][0] - '0') * 4 + (gear[3][0] - '0') * 8);
    }

    static void rot(int idx, int dir) {
        visited[idx] = true;
        char tmp;

        if (idx - 1 >= 0 && !visited[idx - 1] && gear[idx - 1][2] != gear[idx][6]) {
            rot(idx - 1, -dir);
        }
        if (idx + 1 <= 3 && !visited[idx + 1] && gear[idx + 1][6] != gear[idx][2]) {
            rot(idx + 1, -dir);
        }
        if (dir == 1) {
            tmp = gear[idx][7];
            for (int i = 7; i > 0; i--) {
                gear[idx][i] = gear[idx][i - 1];
            }
            gear[idx][0] = tmp;
        } else {
            tmp = gear[idx][0];
            for (int i = 1; i < 8; i++) {
                gear[idx][i - 1] = gear[idx][i];
            }
            gear[idx][7] = tmp;
        }
    }
}
