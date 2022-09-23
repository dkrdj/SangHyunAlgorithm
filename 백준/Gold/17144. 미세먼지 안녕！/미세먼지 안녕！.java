import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T, cleaner;
	static int[][] arr, narr;
	static List<Integer>[][] list;
	static int[] dr = { -1, 0, 0, 1 }, dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		narr = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1)
					cleaner = i;
			}
		}
		for (int i = 0; i < T; i++) {
			first();
			second();
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != -1)
					sum += arr[i][j];
			}
		}
		System.out.println(sum);

	}

	static void first() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] != -1) {
							narr[nr][nc] += arr[i][j] / 5;
							cnt++;
						}
					}
					arr[i][j] -= arr[i][j] / 5 * cnt;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != -1)
					arr[i][j] += narr[i][j];
				narr[i][j] = 0;
			}
		}
	}

	static void second() {
		int start = cleaner - 2;
		while (start - 1 >= 0) {
			arr[start][0] = arr[start - 1][0];
			start--;
		}
		while (start + 1 < C) {
			arr[0][start] = arr[0][start + 1];
			start++;
		}

		start = 0;
		while (start + 1 <= cleaner - 1) {
			arr[start][C - 1] = arr[start + 1][C - 1];
			start++;
		}
		start = C - 1;
		while (start - 1 >= 1) {
			arr[cleaner - 1][start] = arr[cleaner - 1][start - 1];
			start--;
		}
		arr[cleaner - 1][1] = 0;
		//

		start = cleaner + 1;
		while (start + 1 < R) {
			arr[start][0] = arr[start + 1][0];
			start++;
		}
		start = 0;
		while (start + 1 < C) {
			arr[R - 1][start] = arr[R - 1][start + 1];
			start++;
		}
		start = R - 1;
		while (start - 1 >= cleaner) {
			arr[start][C - 1] = arr[start - 1][C - 1];
			start--;
		}
		start = C - 1;
		while (start - 1 >= 0) {
			arr[cleaner][start] = arr[cleaner][start - 1];
			start--;
		}
		arr[cleaner][1] = 0;

	}

}