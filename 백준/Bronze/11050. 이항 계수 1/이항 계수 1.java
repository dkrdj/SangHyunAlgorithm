import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(com(N, K));
	}

	static int com(int n, int k) {
		int sum1 = 1;
		int sum2 = 1;
		for (int i = n - k + 1; i <= n; i++) {
			sum1 *= i;
		}
		for (int i = 2; i <= k; i++) {
			sum2 *= i;
		}
		return sum1 / sum2;
	}
}