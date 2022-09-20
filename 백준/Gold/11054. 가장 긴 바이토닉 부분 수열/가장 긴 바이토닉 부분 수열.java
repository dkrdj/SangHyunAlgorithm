import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] ans1 = new int[n];
		int[] ans2 = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ans1[0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && ans1[i] < ans1[j] + 1) {
					ans1[i] = ans1[j] + 1;
				}
			}
			if (ans1[i] == 0) {
				ans1[i]++;
			}
		}

		ans2[n - 1] = 1;

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[i] > arr[j] && ans2[i] < ans2[j] + 1) {
					ans2[i] = ans2[j] + 1;
				}
			}
			if (ans2[i] == 0) {
				ans2[i]++;
			}
		}

		int[] ans = new int[n];
		int max = 2;
		for (int i = 0; i < n; i++) {
			ans[i] = ans1[i] + ans2[i];
			if (ans[i] > max) {
				max = ans[i];
			}
		}

		System.out.println(max - 1);

	}

}