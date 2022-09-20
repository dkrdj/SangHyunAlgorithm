import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

		}

		for (int i = 1; i < n; i++) {

			st = new StringTokenizer(br.readLine());

			int tmp1 = arr[0];
			int tmp2 = arr[1];
			int tmp3 = arr[2];

			arr[0] = Math.min(tmp2, tmp3) + Integer.parseInt(st.nextToken());
			arr[1] = Math.min(tmp1, tmp3) + Integer.parseInt(st.nextToken());
			arr[2] = Math.min(tmp2, tmp1) + Integer.parseInt(st.nextToken());

		}
		System.out.println(Math.min(Math.min(arr[0], arr[1]), arr[2]));

	}

}