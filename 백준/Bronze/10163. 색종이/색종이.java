import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[4];
		int[][] board = new int[1001][1001];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = A[0]; j < A[0] + A[2]; j++) {
				for (int k = A[1]; k < A[1] + A[3]; k++) {
					board[j][k] = i;
				}
			}
		}
		int[] ans = new int[N + 1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				ans[board[i][j]]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(ans[i] + "\n");
		}
		System.out.println(sb);
	}
}
