import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int[][][] map = new int[21][21][21];

		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				for (int k = 0; k <= 20; k++) {
					if (i == 0 || j == 0 || k == 0) {
						map[i][j][k] = 1;
					} else if (i < j && j < k) {
						map[i][j][k] = map[i][j][k - 1] + map[i][j - 1][k - 1] - map[i][j - 1][k];
					} else {
						map[i][j][k] = map[i - 1][j][k] + map[i - 1][j - 1][k] + map[i - 1][j][k - 1]
								- map[i - 1][j - 1][k - 1];
					}
				}
			}
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;
			int ans = 0;
			if (a <= 0 || b <= 0 || c <= 0)
				ans = 1;
			else if (a > 20 || b > 20 || c > 20)
				ans = map[20][20][20];
			else
				ans = map[a][b][c];
			sb.append("w(" + a + ", " + b + ", " + c + ") = " + ans + "\n");
		}
		System.out.println(sb);

	}
}