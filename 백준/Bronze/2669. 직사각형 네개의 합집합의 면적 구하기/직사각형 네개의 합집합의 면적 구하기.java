import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[4];
		int[][] ans = new int[101][101];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				A[j] = sc.nextInt();
			}
			for (int j = A[0]; j < A[2]; j++) {
				for (int k = A[1]; k < A[3]; k++) {
					ans[j][k] = 1;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				sum += ans[i][j];
			}
		}
		System.out.println(sum);
	}
}
