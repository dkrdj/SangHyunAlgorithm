import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dif = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			dif[i] = Math.abs(arr[i + 1] - arr[i]);
		}
		int gcd = dif[0];
		for (int i = 1; i < dif.length; i++) {
			gcd = GCD(gcd, dif[i]);
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i * i <= gcd; i++) {
			if (gcd % i == 0) {
				ans.add(i);
				if (gcd != i * i) {
					ans.add(gcd / i);
				}
			}
		}
		Collections.sort(ans);
		for (int i = 1; i < ans.size(); i++) {
			sb.append(ans.get(i) + " ");
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