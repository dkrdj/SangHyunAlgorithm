import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];
		permu(0, 0);
		System.out.println(sb);
	}

	static void permu(int idx, int visited) {
		if (idx == M) {
			for (int num : res)
				sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if ((visited & (1 << i)) == 0) {
				res[idx] = i;
				permu(idx + 1, visited | (1 << i));
			}
		}
	}

}