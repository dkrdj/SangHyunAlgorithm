import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static List<Integer>[] list;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			list[v1].add(v2);
			list[v2].add(v1);
		}
		bfs();
		for (int i = 2; i <= N; i++) {
			sb.append(ans[i] + "\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		visited[1] = true;
		Queue<Integer> bfsQueue = new LinkedList<>();
		bfsQueue.add(1);
		while (!bfsQueue.isEmpty()) {
			int tmp = bfsQueue.poll();
			for (int i = 0; i < list[tmp].size(); i++) {
				int num = list[tmp].get(i);
				if (!visited[num]) {
					visited[num] = true;
					ans[num] = tmp;
					bfsQueue.add(num);
				}
			}

		}
	}
}
