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
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Node> list = new ArrayList<>();
		arr = new int[V + 1];
		for (int i = 1; i <= V; i++)
			arr[i] = i;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Node(a, b, c));
		}
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		int idx = 0;
		int sum = 0;
		int cnt = 0;
		while (cnt != V - 1) {
			Node curNode = list.get(idx++);
			int a = curNode.idx1;
			int b = curNode.idx2;
			if (isSame(a, b))
				continue;
			cnt++;
			union(a, b);
			sum += curNode.cost;
		}
		System.out.println(sum);

	}

	static void union(int a, int b) {
		arr[find(b)] = find(a);
	}

	static int find(int a) {
		if (arr[a] == a)
			return a;
		else
			return arr[a] = find(arr[a]);
	}

	static boolean isSame(int a, int b) {
		if (find(a) == find(b))
			return true;
		return false;
	}
}

class Node {
	int idx1;
	int idx2;
	int cost;

	public Node(int idx1, int idx2, int cost) {
		this.idx1 = idx1;
		this.idx2 = idx2;
		this.cost = cost;
	}

}
