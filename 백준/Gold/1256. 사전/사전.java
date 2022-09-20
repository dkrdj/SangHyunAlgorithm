import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		boolean isBigger = false;
		while (comb(N + M, M) == -1) {
			isBigger = true;
			N--;
			sb.append('a');
		}
		if (K > comb(N + M, M) && !isBigger) {
			System.out.println("-1");
			return;
		}
		while (N != 0 && M != 0) {
			long tmp = comb(N + M, M);
			if (tmp * N / (N + M) + 1 > K) {
				sb.append('a');
				N--;
			} else {
				sb.append('z');
				K = K - tmp * N / (N + M);
				M--;
			}
		}
		while (N-- != 0) {
			sb.append('a');
		}
		while (M-- != 0) {
			sb.append('z');
		}
		System.out.println(sb);

	}

	static long comb(int N, int M) {
		long ans = 1;
		int min = Math.min(M, N - M);
		for (int i = 1; i <= min; i++) {
			ans *= (N - min + i);
			ans /= i;
			if (ans <= 0) {
				return -1;
			}
		}
		return ans;
	}

}