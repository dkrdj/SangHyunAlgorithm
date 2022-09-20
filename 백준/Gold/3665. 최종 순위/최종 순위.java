import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			List<Integer>[] list = new ArrayList[N + 1];
			int[] parent = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int val = Integer.parseInt(st.nextToken());
				arr[val] = i;
				parent[val] = i - 1;
				list[i] = new ArrayList<>();
			}
			for (int i = 1; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					list[arr[i]].add(arr[j]);
				}
			}
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (arr[a] > arr[b]) {
					parent[a]--;
					parent[b]++;
				} else {
					parent[a]++;
					parent[b]--;
				}
			}
			boolean isFound = false;

			outer: for (int i = 0; i < N; i++) {
				isFound = false;
				for (int j = 1; j <= N; j++) {
					if (parent[j] == i) {
						isFound = true;
						sb.append(j).append(" ");
						parent[j] = N;
						break;
					} else if (parent[j] < i) {
						System.out.println("?");
						break outer;
					}
				}
				if (!isFound) {
					System.out.println("IMPOSSIBLE");
					break;
				}

			}
			if (isFound)
				System.out.println(sb);
		}
	}
}