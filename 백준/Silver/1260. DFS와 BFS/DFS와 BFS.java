import java.io.*;
import java.util.*;

public class Main {
	static int[] seq1;
	static int[] seq2;
	static int cnt1 = 1;
	static int cnt2 = 1;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new LinkedList[N + 1];
		boolean[] visited = new boolean[N + 1];
		seq1 = new int[N + 1];
		seq2 = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; i++) { // 받아서 리스트에 넣어주기
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for (int i = 1; i < N + 1; i++) { // 리스트별 오름차순정리
			Collections.sort(list[i]);
		}
		dfs(visited, list, V);
		visited = new boolean[N + 1];
		sb.append("\n" + V + " ");
		bfs(visited, list, V);
		System.out.println(sb);
	}

	static void dfs(boolean[] visited, List<Integer>[] list, int V) {
		visited[V] = true;
		sb.append(V + " ");
		for (int i = 0; i < list[V].size(); i++) {
			if (!visited[list[V].get(i)]) {
				dfs(visited, list, list[V].get(i));
			}
		}
	}

	static void bfs(boolean[] visited, List<Integer>[] list, int V) {
		visited[V] = true;
		Queue<Integer> myQueue = new LinkedList<>();
		myQueue.add(V);
		while (!myQueue.isEmpty()) {
			V = myQueue.poll();
			ListIterator<Integer> iter = list[V].listIterator();
			while (iter.hasNext()) {
				int w = iter.next();
				if (!visited[w]) {
					visited[w] = true;
					sb.append(w + " ");
					myQueue.add(w);
				}
			}
		}
	}
}
