import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static List<Node>[] list;
	static long distance = 0;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		visited = new boolean[V + 1];
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			boolean isEnd = false;
			while (true) {
				int v2 = Integer.parseInt(st.nextToken());
				if (v2 == -1) {
					break;
				}
				int w = Integer.parseInt(st.nextToken());
				list[v1].add(new Node(v2, w));
			}

		}
		dfs(1, 0);
		visited = new boolean[V + 1];
		dfs(ans, 0);
		System.out.println(distance);
	}

	static void dfs(int start, long weight) {
		if (weight > distance) {
			distance = weight;
			ans = start;
		}
		visited[start] = true;
		for (int i = 0; i < list[start].size(); i++) {
			int end = list[start].get(i).end;
			long w = list[start].get(i).weight;
			if (!visited[end]) {
				dfs(end, weight + w);
			}

		}
	}
}

class Node {
	int end;
	int weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

}