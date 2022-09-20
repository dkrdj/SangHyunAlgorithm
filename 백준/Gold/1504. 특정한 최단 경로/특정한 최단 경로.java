import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] list;
	static int N, E;
	static int[] dis;
	static boolean isWay = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];

		E = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int sum1 = 0;
		dijkstra(1, v1);
		sum1 += dis[v1];
		dijkstra(v1, v2);
		sum1 += dis[v2];
		dijkstra(v2, N);
		sum1 += dis[N];

		int sum2 = 0;
		dijkstra(1, v2);
		sum2 += dis[v2];
		dijkstra(v2, v1);
		sum2 += dis[v1];
		dijkstra(v1, N);
		sum2 += dis[N];

		if (!isWay) {
			System.out.println("-1");
			return;
		}
		System.out.println(Math.min(sum1, sum2));

	}

	static void dijkstra(int start, int end) {
		dis = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		dis[start] = 0;
		PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});

		que.offer(new Node(start, 0));
		while (!que.isEmpty()) {
			Node curNode = que.poll();
			if (curNode.idx == end)
				return;
			if (curNode.cost > dis[curNode.idx])
				continue;
			for (int i = 0; i < list[curNode.idx].size(); i++) {
				Node nxtNode = list[curNode.idx].get(i);
				if (dis[nxtNode.idx] > curNode.cost + nxtNode.cost) {
					dis[nxtNode.idx] = curNode.cost + nxtNode.cost;
					que.offer(new Node(nxtNode.idx, dis[nxtNode.idx]));
				}
			}
		}
		isWay = false;
	}
}

class Node {
	int idx;
	int cost;

	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}

}