import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n + 1];
		int[] sum = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			if (i < 3) {
				sum[i] = sum[i - 1] + arr[i];
			} else if (i == 3) {
				sum[i] = Math.max(arr[i - 1], arr[i - 2]) + arr[i];
			} else {
				sum[i] = Math.max(Math.max(sum[i - 3], sum[i - 4]) + arr[i - 1], sum[i - 2]) + arr[i];
			}
		}

		System.out.println(Math.max(sum[n], sum[n - 1]));

	}

}