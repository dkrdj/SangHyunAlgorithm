import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, answer = 0;
    static String[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (k < 5) {
            System.out.println(0);
            return;
        }
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        boolean[] visited = new boolean[26];
        visited[0] = true;
        visited[2] = true;
        visited[8] = true;
        visited[13] = true;
        visited[19] = true;
        backtrack(0, visited, 5);
        System.out.println(answer);
    }

    private static void backtrack(int idx, boolean[] visited, int cnt) {
        if (cnt == k) {
            answer = Math.max(answer, check(visited));
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (cnt + 26 - idx < k) {
                return;
            }
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int check(boolean[] visited) {
        int cnt = 0;
        outer:
        for (String str : arr) {
            for (char c : str.toCharArray()) {
                if (!visited[c - 'a']) {
                    continue outer;
                }
            }
            cnt++;
        }
        return cnt;
    }
}