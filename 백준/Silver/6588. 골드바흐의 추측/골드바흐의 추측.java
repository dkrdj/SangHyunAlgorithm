import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] A = new boolean[1000001];
		A[0] = true;
		A[1] = true;
		for (int i = 2; i * i <= 1000000; i++) {
			if (!A[i]) {
				for (int j = i * i; j <= 1000000; j += i) {
					A[j] = true;
				}
			}
		}
		List<Integer> prime = new ArrayList<>();
		for (int i = 2; i <= 1000000; i++) {
			if (!A[i]) {
				prime.add(i);
			}
		}
		while (true) {
			int N = Integer.parseInt(br.readLine());
			boolean isPrime = false;
			if (N == 0)
				break;
			for (int i = 0; prime.get(i) <= N; i++) {
				if(!A[N-prime.get(i)]) {
					sb.append(N + " = " + prime.get(i) + " + " + (N-prime.get(i)) + "\n");
					isPrime = true;
					break;
				}
			}
			if(!isPrime) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
		System.out.println(sb);
	}
}
