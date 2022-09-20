import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] A = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		for (int k = 0; k < K; k++) {
			int first_i = sc.nextInt();
			int	first_j = sc.nextInt();
			int	final_x = sc.nextInt();
			int	final_y = sc.nextInt();

			int ans = 0;
			for (int i = first_i ; i <= final_x; i++) {
				for (int j = first_j ; j <= final_y; j++) {
					ans += A[i][j];
				}
			}
			System.out.println(ans);
		}
	}
}