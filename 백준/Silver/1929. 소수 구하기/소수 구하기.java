import java.util.*;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] A = new boolean[N + 1];
		A[0] = true;
		A[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if (!A[i]) {
				for (int j = i * i; j <= N; j += i) {
					A[j] = true;
				}
			}
		}
		for (int i = M; i <= N; i++) {
			if (!A[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}