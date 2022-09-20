import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] rad = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			rad[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			int gcd = GCD(Math.min(rad[0], rad[i]), Math.max(rad[0], rad[i]));
			sb.append(rad[0] / gcd + "/" + rad[i] / gcd + "\n");
		}
		System.out.println(sb);
	}

	static int GCD(int a, int b) {
		if (b % a == 0) {
			return a;
		}
		return GCD(b % a, a);
	}

}