import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Edge> edges = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			edges.add(new Edge(x, y, z, i));
		}
		List<Node> list = new ArrayList<>();
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}

		});
		for (int i = 1; i < N; i++) {
			list.add(new Node(edges.get(i - 1).num, edges.get(i).num, edges.get(i).x - edges.get(i - 1).x));
		}
		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}

		});
		for (int i = 1; i < N; i++) {
			list.add(new Node(edges.get(i - 1).num, edges.get(i).num, edges.get(i).y - edges.get(i - 1).y));
		}
		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.z - o2.z;
			}

		});
		for (int i = 1; i < N; i++) {
			list.add(new Node(edges.get(i - 1).num, edges.get(i).num, edges.get(i).z - edges.get(i - 1).z));
		}
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		int cnt = 0;
		long sum = 0;
		for (int i = 0; cnt < N - 1; i++) {
			Node curNode = list.get(i);
			if (!isSame(curNode.start, curNode.end)) {
				union(curNode.start, curNode.end);
				sum += curNode.cost;
				cnt++;
			}
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

class Edge {
	int num;
	int x;
	int y;
	int z;

	public Edge(int x, int y, int z, int num) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.num = num;
	}

}

class Node {
	int start;
	int end;
	int cost;

	public Node(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

}