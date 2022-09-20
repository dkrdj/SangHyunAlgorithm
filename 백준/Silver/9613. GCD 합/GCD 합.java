import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 1; j + k < N; k++) {
					sum += GCD(Math.min(A[j], A[j + k]), Math.max(A[j], A[j + k]));
				}
			}
			sb.append(sum + "\n");
		}
		System.out.print(sb);
	}

	static int GCD(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return GCD(b, a % b);
	}
}