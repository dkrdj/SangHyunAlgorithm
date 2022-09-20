import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[8001];
		int MAX = -4000;
		int MIN = 4000;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			A[num + 4000]++;
			if (num > MAX) {
				MAX = num;
			}
			if (num < MIN) {
				MIN = num;
			}
			sum += num;
		}
		// 오름차순 정렬

		// 최빈값 탐색
		int cnt = 0;
		int ans = 11111;
		boolean more = false;
		for (int i = 0; i < 8001; i++) {
			if (A[i] > 0) {
				if (A[i] > cnt) {
					cnt = A[i];
					more = false;
					ans = i - 4000;
				} else if (A[i] == cnt && !more) {
					more = true;
					ans = i - 4000;
				}
			}
		}
		int[] res = new int[N];
		int idx = 0;
		for (int i = 0; i < 8001; i++) {
			while (A[i] > 0) {
				res[idx++] = i - 4000;
				A[i]--;
			}
		}
		System.out.print(Math.round((float) sum / N) + "\n" + res[N / 2] + "\n" + ans + "\n" + (MAX - MIN));

	}
}