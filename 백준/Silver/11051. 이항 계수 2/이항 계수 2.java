import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] ans = new int[N + 1][N + 1];
		// nCk로 배열.
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == 1 || j == 0 || j == i) {
					ans[i][j] = 1;
				} else {
					ans[i][j] = (ans[i - 1][j - 1] + ans[i - 1][j]) % 10007;
				}
			}
		}
		System.out.println(ans[N][K]);
	}

}