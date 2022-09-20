import java.io.*;
import java.util.*;

public class Main {
	static List<Node>[] list;
	static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V + 1];
		dis = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
			dis[i] = Integer.MAX_VALUE;
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if (dis[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dis[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra(int start) {
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
			if (dis[curNode.idx] < curNode.cost)
				continue;
			for (int i = 0; i < list[curNode.idx].size(); i++) {
				Node nxtNode = list[curNode.idx].get(i);
				if (dis[nxtNode.idx] > curNode.cost + nxtNode.cost) {
					dis[nxtNode.idx] = curNode.cost + nxtNode.cost;
					que.offer(new Node(nxtNode.idx, dis[nxtNode.idx]));
				}
			}
		}
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