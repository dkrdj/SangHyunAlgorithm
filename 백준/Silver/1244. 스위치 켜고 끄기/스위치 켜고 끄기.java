import java.util.*;
import java.io.*;

public class Main {
	static int[] sw;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		sw = new int[N];
		int cnt = 0;
		for (int i = 0; i < (N % 20 == 0 ? N / 20 : N / 20 + 1) && cnt < N; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				sw[cnt++] = Integer.parseInt(st.nextToken());
			}
		}
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			change(n, m - 1);
		}
		for (int i = 0; i < (N % 20 == 0 ? N / 20 : N / 20 + 1); i++) {
			for (int j = 0; j < 20; j++) {
				if (20 * i + j < N) {
					sb.append(sw[20 * i + j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void change(int n, int m) {
		if (n == 1) {
			for (int i = m; i < N && i >= 0; i += (m + 1)) {
				sw[i] = 1 - sw[i];
			}
		} else {
			int cnt = 0;
			for (int i = 1; (m - i) >= 0 && (m + i) < N; i++) {
				if (sw[m - i] != sw[m + i]) {
					break;
				}
				cnt = i;
			}
			sw[m] = 1 - sw[m];
			for (int i = 1; i <= cnt ; i++) {
				sw[m - i] = 1 - sw[m - i];
				sw[m + i] = 1 - sw[m + i];
			}
		}
	}
}