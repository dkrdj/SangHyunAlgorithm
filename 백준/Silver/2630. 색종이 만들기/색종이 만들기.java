import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int blue, white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check(arr, 0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void check(int[][] arr, int r, int c, int size) {
        int sum = sum(arr, r, c, size);
        if (sum == size * size) {
            blue++;
        } else if (sum == 0) {
            white++;
        } else {
            check(arr, r, c, size / 2);
            check(arr, r + size / 2, c, size / 2);
            check(arr, r, c + size / 2, size / 2);
            check(arr, r + size / 2, c + size / 2, size / 2);
        }
    }

    static int sum(int[][] arr, int r, int c, int size) {
        int sum = 0;
        for (int i = r; i < r + size; i++)
            for (int j = c; j < c + size; j++)
                sum += arr[i][j];
        return sum;
    }
}
