import java.io.*;
import java.util.*;

public class Main {
	static int h;
	static int w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dis[i] = distance(a, b);
		}
		int round = 2 * w + 2 * h;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Math.abs(dis[N] - dis[i]);
			sum += Math.min(round - tmp, tmp);
		}
		System.out.println(sum);
	}

	static int distance(int x, int y) {
		if (x == 1) {
			return y;
		} else if (x == 2) {
			return -(y + h);
		} else if (x == 3) {
			return -y;
		} else {
			return w + y;
		}
	}

}