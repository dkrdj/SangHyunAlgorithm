import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
		}
		int tmp = max;
		for (int i = k; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp = tmp - arr[i - k] + arr[i];
			if (tmp > max)
				max = tmp;
		}
		System.out.println(max);
	}
}
