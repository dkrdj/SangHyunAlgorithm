import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 1;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 정점개수
		int M = Integer.parseInt(st.nextToken());// 간선갯수
		int R = Integer.parseInt(st.nextToken());// 시작점
		boolean[] visited = new boolean[N + 1];
		seq = new int[N + 1];

		Map<Integer, List<Integer>> node = new HashMap<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (!node.containsKey(u)) {
				List<Integer> list = new ArrayList<>();
				node.put(u, list);
			}
			node.get(u).add(v);
			if (!node.containsKey(v)) {
				List<Integer> list = new ArrayList<>();
				node.put(v, list);
			}
			node.get(v).add(u);
		}
		for (List<Integer> value : node.values()) {
			Collections.sort(value, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
				
			});
		}
		dfs(R, visited, node);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(seq[i] + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int R, boolean[] visited, Map<Integer, List<Integer>> node) {
		seq[R] = cnt++;
		visited[R] = true;
		List<Integer> list = node.get(R);
		for (int i = 0; i < (list == null ? 0 : list.size()); i++) {
			if (!visited[list.get(i)]) {// 방문하지 않고 연결된애들
				dfs(list.get(i), visited, node);
			}
		}
	}
}