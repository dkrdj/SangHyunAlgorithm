import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, d));
		}
		long[] ans = bp(1);
		if (ans == null)
			sb.append("-1");
		else
			for (int i = 2; i <= N; i++)
				sb.append(ans[i] == Long.MAX_VALUE ? -1 : ans[i]).append("\n");
		System.out.println(sb);
	}

	static long[] bp(int start) {
		long[] dis = new long[N + 1];
		int[] cycle = new int[N + 1];
		boolean[] nq = new boolean[N + 1];
		Arrays.fill(dis, Long.MAX_VALUE);
		dis[start] = 0;
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		nq[start] = true;
		while (!que.isEmpty()) {
			int curNode = que.poll();
			nq[curNode] = false;
			for (Node nxtNode : list[curNode]) {
				if (dis[nxtNode.idx] > dis[curNode] + nxtNode.cost) {
					dis[nxtNode.idx] = dis[curNode] + nxtNode.cost;
					if (!nq[nxtNode.idx]) {
						que.offer(nxtNode.idx);
						nq[nxtNode.idx] = true;
						cycle[curNode]++;
						if (cycle[curNode] >= N)
							return null;
					}
				}
			}
		}
		return dis;
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