import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visited = new boolean[K * 2];
		if (N == K) {
			System.out.println(0);
		} else if (N > K) {
			System.out.println(N - K);
		} else {
			bfs(N, K);
		}
	}

	static void bfs(int N, int K) {
		visited[N] = true;
		Queue<Node> bfsQueue = new LinkedList<>();
		bfsQueue.add(new Node(N, 0));
		while (!bfsQueue.isEmpty()) {
			Node tmp = bfsQueue.poll();
			int N1 = tmp.x - 1;
			int N2 = tmp.x + 1;
			int N3 = tmp.x * 2;
			if (N1 == K || N2 == K || N3 == K) {
				System.out.println(tmp.cnt + 1);
				return;
			} else {
				if (N1 < K * 2 && N1 >= 0)
					if (!visited[N1]) {
						visited[N1] = true;
						bfsQueue.add(new Node(N1, tmp.cnt + 1));
					}
				if (N2 < K * 2 && N2 >= 0)
					if (!visited[N2]) {
						visited[N2] = true;
						bfsQueue.add(new Node(N2, tmp.cnt + 1));
					}
				if (N3 < K * 2 && N3 >= 0)
					if (!visited[N3]) {
						visited[N3] = true;
						bfsQueue.add(new Node(N3, tmp.cnt + 1));
					}
			}

		}
	}
}

class Node {
	int x;
	int cnt;

	Node(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}