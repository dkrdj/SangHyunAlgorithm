import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// mCn구하기.
			int[][] ans = new int[M + 1][M + 1];
			for (int i = 1; i <= M; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == 1 || j == 0 || j == i) {
						ans[i][j] = 1;
					} else {
						ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
					}
				}
			}
			System.out.println(ans[M][N]);
		}
	}

}