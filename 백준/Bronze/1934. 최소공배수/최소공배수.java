import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int min = Math.min(A, B);
			int max = Math.max(A, B);

			sb.append(min * max / GCD(min, max) + "\n");
		}
		System.out.println(sb);
	}

	static int GCD(int a, int b) {
		if (b % a == 0) {
			return a;
		} else {
			return GCD(b % a, a);
		}
	}

}