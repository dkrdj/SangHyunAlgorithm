import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[] A = new boolean[1000001];
		for (int i = 2; i * i <= 1000000; i++) {
			if (!A[i]) {
				for (int j = i * i; j <= 1000000; j += i) {
					A[j] = true;
				}
			}
		}
		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= 1000000; i++) {
			if (!A[i]) {
				primeList.add(i);
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int j = 0; primeList.get(j) * 2 <= N; j++) {
				if (A[N - primeList.get(j)] == false) {
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

}