import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr;
	static int N, M, H;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new boolean[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
		}

		func(0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	static void func(int idx) {
		if (check()) {
			min = Math.min(min, idx);
			return;
		}
		if (idx == 3) {
			return;
		}
		for (int i = 1; i <= H; i++) {
			// arr[i][j] 가 true면 j와 j+1을 이어줌. j-1과 j+1이 false여야함. 근데 j-1이 0이거나 j+1이 N이면 ㄱㅊ
			for (int j = 1; j <= N - 1; j++) {
				if (!arr[i][j] && (j - 1 <= 0 || !arr[i][j - 1]) && (j + 1 >= N || !arr[i][j + 1])) {
					arr[i][j] = true;
					func(idx + 1);
					arr[i][j] = false;
				}
			}
		}
	}

	static boolean check() {
		for (int i = 1; i <= N; i++)
			if (i != ladder(i))
				return false;
		return true;
	}

	static int ladder(int start) {
		for (int i = 1; i <= H; i++) {
			if (arr[i][start]) {
				start++;
			} else if (start - 1 >= 1 && arr[i][start - 1]) {
				start--;
			}
		}
		return start;
	}

}
