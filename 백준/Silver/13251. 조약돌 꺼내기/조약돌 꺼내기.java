import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); // M은 색깔의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[M]; // 색깔마다 수 대입
		int N = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			N += arr[i]; // 전체 구슬 개수
		}
		int K = Integer.parseInt(br.readLine()); // 몇개를 뽑을거냐
		double ans = 0;
		for (int i = 0; i < M; i++) {
			ans += calc(N, arr[i], K);
		}
		System.out.println(ans);
	}

	static double calc(int N, int M, int K) {
		double ans = 1;
		for (int i = 0; i < K; i++) {
			ans *= ((double) (M - i) / (double) (N - i));
		}
		return ans;
	}

}