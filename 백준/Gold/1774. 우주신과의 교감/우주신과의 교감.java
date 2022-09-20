import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[N + 1];
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(x, y);
			arr[i] = i;
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (!isSame(start, end)) {
				union(start, end);
				cnt++;
			}
		}
		List<Node> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double cost = Math.sqrt((edges[i].x - edges[j].x) * (edges[i].x - edges[j].x)
						+ (edges[i].y - edges[j].y) * (edges[i].y - edges[j].y));
				list.add(new Node(i, j, cost));
			}
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Double.compare(o1.cost, o2.cost);
			}
		});
		double sum = 0;

		for (int i = 0; cnt < N - 1; i++) {
			Node curNode = list.get(i);
			int start = curNode.start;
			int end = curNode.end;
			if (!isSame(start, end)) {
				union(start, end);
				cnt++;
				sum += curNode.cost;
			}
		}
		sum = (double) (Math.round(sum * 100)) / 100;
		System.out.printf("%.2f", sum);

	}

	static void union(int a, int b) {
		arr[find(b)] = find(a);
	}

	static int find(int a) {
		if (arr[a] == a)
			return a;
		return arr[a] = find(arr[a]);
	}

	static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}

}

class Edge {
	long x;
	long y;

	public Edge(long x, long y) {
		this.x = x;
		this.y = y;
	}

}

class Node {
	int start;
	int end;
	double cost;

	public Node(int start, int end, double cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

}