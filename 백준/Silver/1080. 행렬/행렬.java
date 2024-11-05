import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] before = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            for (int j = 0; j < m; j++) {
                before[i][j] = ch[j] - '0';
            }
        }
        int[][] after = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            for (int j = 0; j < m; j++) {
                after[i][j] = ch[j] - '0';
            }
        }
        int cnt = 0;
        for (int i = 0; i < n + m - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < n - 2 && i - j < m - 2 && before[j][i - j] != after[j][i - j]) {
                    for (int k = j; k < j + 3; k++) {
                        for (int l = i - j; l < i - j + 3; l++) {
                            before[k][l] = 1 - before[k][l];
                        }
                    }
                    cnt++;
                }
            }
        }
        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
