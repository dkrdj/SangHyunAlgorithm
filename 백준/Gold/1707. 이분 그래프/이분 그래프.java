import java.io.*;
import java.util.*;

public class Main {

	static boolean isBG;
	static boolean[] visited;
	static int[] ans;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		for (int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			for (int i = 0; i < V + 1; i++) {
				list[i] = new ArrayList<Integer>();
			}
			visited = new boolean[V + 1];
			ans = new int[V + 1];
			int[] v1 = new int[E];
			int[] v2 = new int[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				v1[i] = Integer.parseInt(st.nextToken());
				v2[i] = Integer.parseInt(st.nextToken());
				list[v1[i]].add(v2[i]);
				list[v2[i]].add(v1[i]);
			}
			for (int i = 1; i <= V; i++) {
				if (!visited[i]) {
					bfs(V, i);
				}
			}

			boolean isBG = true;
			end: for (int i = 0; i < v1.length; i++) {
				if (ans[v1[i]] == ans[v2[i]]) {
					isBG = false;
					break end;
				}
			}

			if (isBG) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static void bfs(int V, int N) {
		visited[N] = true;
		ans[N] = 1;
		Queue<Integer> bfsQueue = new LinkedList<>();
		bfsQueue.add(N);
		while (!bfsQueue.isEmpty()) {
			int tmp = bfsQueue.poll();
			for (int i = 0; i < list[tmp].size(); i++) {
				int num = list[tmp].get(i);
				if (!visited[num]) {
					ans[num] = 1 - ans[tmp];
					visited[num] = true;
					bfsQueue.add(num);
				}
			}
		}
	}
}