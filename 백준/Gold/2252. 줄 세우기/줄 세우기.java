import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] parent = new int[N + 1];
		List<Integer>[] childList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			childList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			childList[a].add(b);
			parent[b]++;
		}

		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (parent[i] == 0) {
				que.add(i);
			}
		}

		while (!que.isEmpty()) {
			int tmp = que.poll();
			List<Integer> list = childList[tmp];
			for (int i = 0; i < list.size(); i++) {
				if (--parent[list.get(i)] == 0)
					que.add(list.get(i));
			}
			sb.append(tmp).append(" ");
		}
		System.out.println(sb);

	}
}
