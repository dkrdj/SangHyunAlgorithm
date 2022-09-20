import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n + 1];
		arr[0][1] = Integer.parseInt(br.readLine());

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
			}
		}

		int max = 0;

		for (int i = 1; i <= n; i++) {
			max = max > arr[n - 1][i] ? max : arr[n - 1][i];
		}

		System.out.println(max);
	}

}