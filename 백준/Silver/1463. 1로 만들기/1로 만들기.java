import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] f = new int[n + 1];

		f[1] = 0;
		for (int i = 2; i <= n; i++) {
			int tmp1 = 1000000, tmp2 = 1000000, tmp3 = 1000000;
			if (i % 3 == 0) {
				tmp1 = f[i / 3] + 1;
			}
			if (i % 2 == 0) {
				tmp2 = f[i / 2] + 1;
			}
			tmp3 = f[i - 1] + 1;
			f[i] = Math.min(tmp1, Math.min(tmp2, tmp3));
		}
		System.out.println(f[n]);

	}

}