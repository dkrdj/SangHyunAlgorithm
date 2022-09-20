import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] weight;
	static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println("0");
			return;
		}
		visited = new boolean[N + 1];
		weight = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}

		bfs(1);
		int idx = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (weight[i] > max) {
				max = weight[i];
				idx = i;
			}
		}
		visited = new boolean[N + 1];
		weight = new int[N + 1];
		bfs(idx);
		for (int i = 1; i <= N; i++) {
			if (weight[i] > max) {
				max = weight[i];
			}
		}
		System.out.println(max);
	}

	static void bfs(int start) {
		visited[start] = true;
		weight[start] = 0;
		Queue<Integer> bfsQueue = new LinkedList<>();
		bfsQueue.add(start);
		while (!bfsQueue.isEmpty()) {
			int tmp = bfsQueue.poll();
			for (int i = 0; i < list[tmp].size(); i++) {
				Node node = list[tmp].get(i);
				if (!visited[node.end]) {
					visited[node.end] = true;
					bfsQueue.add(node.end);
					weight[node.end] = weight[tmp] + node.weight;
				}
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
