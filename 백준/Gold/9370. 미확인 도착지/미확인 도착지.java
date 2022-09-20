import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			list = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b, d));
				list[b].add(new Node(a, d));
			}
			PriorityQueue<Integer> ansQue = new PriorityQueue<>();
			int disSG = dijkstra(s, g);
			int disSH = dijkstra(s, h);
			int disGH = dijkstra(g, h);
			for (int i = 0; i < t; i++) {
				int end = Integer.parseInt(br.readLine());
				int ans = Math.min(disSG + disGH + dijkstra(h, end), disSH + disGH + dijkstra(g, end));
				if (ans == dijkstra(s, end))
					ansQue.offer(end);
			}
			while (!ansQue.isEmpty())
				sb.append(ansQue.poll()).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int dijkstra(int start, int end) {
		int[] dis = new int[n + 1];
		for (int i = 1; i <= n; i++)
			dis[i] = Integer.MAX_VALUE;
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
				break;
			if (curNode.cost > dis[curNode.idx])
				continue;
			for (int i = 0; i < list[curNode.idx].size(); i++) {
				Node nxtNode = list[curNode.idx].get(i);
				if (dis[nxtNode.idx] > nxtNode.cost + curNode.cost) {
					dis[nxtNode.idx] = nxtNode.cost + curNode.cost;
					que.offer(new Node(nxtNode.idx, dis[nxtNode.idx]));
				}
			}
		}
		return dis[end];
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