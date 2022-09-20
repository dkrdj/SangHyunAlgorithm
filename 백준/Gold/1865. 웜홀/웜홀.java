import java.io.*;
import java.util.*;

public class Main {
	static int N, M, W;
	static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		outer : for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				list[S].add(new Node(E, T));
				list[E].add(new Node(S, T));
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				list[S].add(new Node(E, -T));
			}
			for (int i = 1; i <= N; i++) {
				int tmp = bp(i);
				if (tmp == -1) {
					System.out.println("YES");
					continue outer;
				}
			}
			System.out.println("NO");

		}
	}

	static int bp(int start) {
		int[] dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		boolean[] nq = new boolean[N + 1];
		int[] cycle = new int[N + 1];

		dis[start] = 0;
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		nq[start] = true;
		cycle[start]++;
		while (!que.isEmpty()) {
			int cur = que.poll();
			nq[cur] = false;
			for (Node nxtNode : list[cur]) {
				if (dis[nxtNode.idx] > dis[cur] + nxtNode.cost) {
					if (nxtNode.idx == start)
						return -1;
					dis[nxtNode.idx] = dis[cur] + nxtNode.cost;
					if (!nq[nxtNode.idx]) {
						que.offer(nxtNode.idx);
						nq[nxtNode.idx] = true;
						if (++cycle[nxtNode.idx] >= N)
							return -1;
					}
				}
			}
		}
		return 1;
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