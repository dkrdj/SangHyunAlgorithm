import java.io.*;
import java.util.*;

public class Main {
	static boolean isTree;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int tc = 1;
		while (!(n == 0 && m == 0)) {
			boolean[] visited = new boolean[n + 1];
			list = new List[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
				list[end].add(start);
			}
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					isTree = true;
					findTree(i, visited, 0);
					if (isTree)
						cnt++;
				}
			}
			sb.append("Case ").append(tc++).append(": ");
			if (cnt == 0) {
				sb.append("No trees.\n");
			} else if (cnt == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of ").append(cnt).append(" trees.\n");
			}
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}

	static void findTree(int select, boolean[] visited, int root) {
		visited[select] = true;
		for (int i = 0; i < list[select].size(); i++) {
			if (list[select].get(i) != root) {
				if (visited[list[select].get(i)]) {
					isTree = false;
				} else {
					findTree(list[select].get(i), visited, select);
				}
			}
		}
	}

}