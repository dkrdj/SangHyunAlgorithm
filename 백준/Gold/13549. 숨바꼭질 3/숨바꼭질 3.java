import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dis = new int[200001];
		for (int i = 0; i <= 200000; i++) {
			dis[i] = Integer.MAX_VALUE;
		}

		dijkstra(N, K);
		System.out.println(dis[K]);
	}

	static void dijkstra(int start, int end) {
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

			int nxtIdx = curNode.idx + 1;
			if (nxtIdx <= 200000 && dis[nxtIdx] > curNode.cost + 1) {
				dis[nxtIdx] = curNode.cost + 1;
				que.offer(new Node(nxtIdx, dis[nxtIdx]));
			}

			nxtIdx = curNode.idx - 1;
			if (nxtIdx >= 0 && dis[nxtIdx] > curNode.cost + 1) {
				dis[nxtIdx] = curNode.cost + 1;
				que.offer(new Node(nxtIdx, dis[nxtIdx]));
			}

			for (int i = 1; curNode.idx > 0 && (int) Math.pow(2, i) * curNode.idx <= 200000; i++) {
				nxtIdx = curNode.idx * (int) Math.pow(2, i);
				if (dis[nxtIdx] > curNode.cost) {
					dis[nxtIdx] = curNode.cost;
					que.offer(new Node(nxtIdx, dis[nxtIdx]));
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