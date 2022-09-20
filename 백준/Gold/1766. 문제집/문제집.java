import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int[] parent = new int[N + 1];
		Queue<Integer>[] child = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++)
			child[i] = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			child[a].add(b);
			parent[b]++;
		}

		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 1; i <= N; i++)
			if (parent[i] == 0)
				que.add(i);

		while (!que.isEmpty()) {
			int tmp = que.poll();
			while (!child[tmp].isEmpty()) {
				int child1 = child[tmp].poll();
				if (--parent[child1] == 0)
					que.add(child1);
			}
			sb.append(tmp).append(" ");
		}

		System.out.println(sb);
	}
}