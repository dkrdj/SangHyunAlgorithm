import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] ans = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;
		ans[0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && ans[i] < ans[j] + 1) {
					ans[i] = ans[j] + 1;
				}
			}
			if (ans[i] == 0) {
				ans[i]++;
			}
			if (ans[i] > max) {
				max = ans[i];
			}
		}

		System.out.println(max);

	}

}