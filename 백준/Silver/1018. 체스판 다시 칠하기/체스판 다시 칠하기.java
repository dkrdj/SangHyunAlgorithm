import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				switch (str.charAt(j)) {
				case 'W':
					A[i][j] = 0;
					break;
				case 'B':
					A[i][j] = 1;
					break;
				default:
					System.out.println("오류");
				}
			}
		}
		int[][] sample1 = new int[8][8];
		int[][] sample2 = new int[8][8];
		sample1[0][0] = 0;
		sample2[0][0] = 1;
		for (int i = 1; i < 8; i++) {
			sample1[0][i] = 1 - sample1[0][i-1];
		}
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sample1[i][j] = 1 - sample1[i - 1][j];
			}
		}
		for (int i = 1; i < 8; i++) {
			sample2[0][i] = 1 - sample2[0][i-1];
		}
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sample2[i][j] = 1 - sample2[i - 1][j];
			}
		}
		int ans = 64;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int cnt = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (A[i + k][j + l] != sample1[k][l])
							cnt++;
					}
				}
				if (ans > cnt) {
					ans = cnt;
				}
				cnt = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (A[i + k][j + l] != sample2[k][l])
							cnt++;
					}
				}
				if (ans > cnt) {
					ans = cnt;
				}
			}
		}
		System.out.println(ans);
	}
}