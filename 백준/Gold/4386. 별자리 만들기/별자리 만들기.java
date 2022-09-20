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
		int n = Integer.parseInt(br.readLine());
		List<Edge> edgeList = new ArrayList<>();
		List<Node> nodeList = new ArrayList<>();
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			edgeList.add(new Edge(x, y));
			arr[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double x1 = edgeList.get(i).x;
				double y1 = edgeList.get(i).y;
				double x2 = edgeList.get(j).x;
				double y2 = edgeList.get(j).y;
				double cost = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
				nodeList.add(new Node(i + 1, j + 1, cost));
			}
		}

		Collections.sort(nodeList, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return Double.compare(o1.cost, o2.cost);
			}

		});

		double sum = 0;
		int cnt = 0;
		int idx = 0;
		while (cnt != n - 1) {
			Node node = nodeList.get(idx++);
			if(isSame(node.start,node.end))
				continue;
			cnt++;
			union(node.start, node.end);
			sum += node.cost;
		}
		System.out.println(sum);
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

class Edge {
	double x;
	double y;

	public Edge(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o instanceof Edge) {
			Edge node = (Edge) o;
			return Double.compare(node.x, x) == 0 && Double.compare(node.y, y) == 0;
		}
		return false;
	}

}
