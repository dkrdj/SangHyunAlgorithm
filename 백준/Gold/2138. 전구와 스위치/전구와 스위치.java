import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] before = new int[n];
        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            before[i] = Character.getNumericValue(ch[i]);
        }
        int[] after = new int[n];
        ch = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            after[i] = Character.getNumericValue(ch[i]);
        }
        boolean[] visited = new boolean[n];
        int[] tmp = new int[n];
        boolean isSame = false;
        while (true) {
            System.arraycopy(before, 0, tmp, 0, n);
            visited = new boolean[n];
            isSame = test(n, tmp, after, visited);
            if (isSame) {
                break;
            }

            System.arraycopy(before, 0, tmp, 0, n);
            visited = new boolean[n];
            if (n >= 3) {
                tmp[0] ^= 1;
                tmp[1] ^= 1;
                visited[0] = !visited[0];
            }
            isSame = test(n, tmp, after, visited);
            if (isSame) {
                break;
            }

            System.arraycopy(before, 0, tmp, 0, n);
            visited = new boolean[n];
            if (n >= 3) {
                tmp[n - 1] ^= 1;
                tmp[n - 2] ^= 1;
                visited[n - 1] = !visited[n - 1];
            }
            isSame = test(n, tmp, after, visited);
            if (isSame) {
                break;
            }

            System.arraycopy(before, 0, tmp, 0, n);
            visited = new boolean[n];
            if (n >= 3) {
                tmp[0] ^= 1;
                tmp[1] ^= 1;
                visited[0] = !visited[0];
                tmp[n - 1] ^= 1;
                tmp[n - 2] ^= 1;
                visited[n - 1] = !visited[n - 1];
            }
            isSame = test(n, tmp, after, visited);
            if (isSame) {
                break;
            }
            break;
        }

        if (isSame) {
            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    answer++;
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean test(int n, int[] before, int[] after, boolean[] visited) {
        for (int i = 0; i < n - 1; i++) {
            if (before[i] != after[i]) {
                for (int j = i; j < i + 3 && j < n; j++) {
                    before[j] ^= 1;
                }
                visited[i + 1] = !visited[i + 1];
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (before[i] != after[i]) {
                for (int j = i; j > i - 3 && j >= 0; j--) {
                    before[j] ^= 1;
                }
                visited[i - 1] = !visited[i - 1];
            }
        }

        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            if (before[i] != after[i]) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }
}
