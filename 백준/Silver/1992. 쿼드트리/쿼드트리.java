import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static int N, M, H;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = c[j] - '0';
			}
		}
		div(0, 0, N);
		System.out.println(sb);
	}

	static void div(int sr, int sc, int size) {
		int sum = sum(sr, sc, size);
		if (sum == size * size) {
			sb.append(1);
			return;
		} else if (sum == 0) {
			sb.append(0);
			return;
		}
		sb.append("(");
		div(sr, sc, size / 2);
		div(sr, sc + size / 2, size / 2);
		div(sr + size / 2, sc, size / 2);
		div(sr + size / 2, sc + size / 2, size / 2);
		sb.append(")");
	}

	static int sum(int r, int c, int size) {
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

}
