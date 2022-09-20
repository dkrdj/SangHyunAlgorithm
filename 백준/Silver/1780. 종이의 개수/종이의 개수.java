import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int minusSum, zeroSum, plusSum;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(0, 0, N);
		sb.append(minusSum).append("\n").append(zeroSum).append("\n").append(plusSum).append("\n");
		System.out.println(sb);
	}

	static void div(int sr, int sc, int size) {
		int minus = 0, plus = 0, zero = 0;
		for (int i = sr; i < sr + size; i++) {
			for (int j = sc; j < sc + size; j++) {
				if (arr[i][j] == -1)
					minus++;
				else if (arr[i][j] == 0)
					zero++;
				else
					plus++;
			}
		}
		if (minus == size * size) {
			minusSum++;
			return;
		} else if (zero == size * size) {
			zeroSum++;
			return;
		} else if (plus == size * size) {
			plusSum++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				div(sr + size / 3 * i, sc + size / 3 * j, size / 3);
			}
		}
	}

}
