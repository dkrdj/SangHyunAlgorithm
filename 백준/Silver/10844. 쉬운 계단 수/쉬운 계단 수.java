import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][10];

		for (int i = 0; i <= 9; i++) {
			arr[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j - 1 >= 0)
					arr[i][j] += arr[i - 1][j - 1];
				if (j + 1 <= 9)
					arr[i][j] += arr[i - 1][j + 1];
				arr[i][j] %= 1000000000;
			}
		}
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum += arr[n][i];
			sum %= 1000000000;
		}
		System.out.println(sum);

	}

}