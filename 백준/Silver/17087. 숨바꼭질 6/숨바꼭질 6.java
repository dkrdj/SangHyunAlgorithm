import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N + 1];
		A[0] = S;
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int ans = Math.abs(A[1] - A[0]);
		for (int i = 1; i < N ; i++) {
			ans = GCD(ans, Math.abs(A[i + 1] - A[i]));
		}
		System.out.println(ans);
	}

	static int GCD(int a, int b) {
		if (a > b) {
			if (a % b == 0) {
				return b;
			}
			return GCD(b, a % b);
		} else {
			if (b % a == 0) {
				return a;
			}
			return GCD(a, b % a);
		}
	}
}