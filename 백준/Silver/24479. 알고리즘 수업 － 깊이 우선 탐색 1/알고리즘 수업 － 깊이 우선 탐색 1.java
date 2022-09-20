import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] ans;
	static List<Integer>[] map;
	static int cnt = 1;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		ans = new int[N + 1];
		map = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u].add(v);
			map[v].add(u);
		}
		
		for (int i = 1; i <= N; i++)
			Collections.sort(map[i]);
		
		dfs(R);
		
		for (int i = 1; i <= N; i++)
			sb.append(ans[i]).append("\n");

		System.out.println(sb);
	}

	static void dfs(int start) {
		ans[start] = cnt++;
		visited[start] = true;
		for (int end : map[start])
			if (!visited[end])
				dfs(end);
	}
}
