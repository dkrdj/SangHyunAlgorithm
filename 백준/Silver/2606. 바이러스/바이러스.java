import java.io.*;
import java.util.*;

public class Main {
	static boolean[] infested;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		int connect = Integer.parseInt(br.readLine());
		List<Integer>[] list = new LinkedList[num + 1];
		boolean[] visited = new boolean[num + 1];
		infested = new boolean[num + 1];
		for (int i = 1; i < num + 1; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < connect; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		dfs(visited, list, 1);
		int cnt = 0;
		for (int i = 1; i < num + 1; i++) {
			if (infested[i]) {
				cnt++;
			}
		}
		System.out.println(cnt - 1);
	}

	static void dfs(boolean[] visited, List<Integer>[] list, int num) {
		visited[num] = true;
		infested[num] = true;
		for (int i = 0; i < list[num].size(); i++) {
			if (!visited[list[num].get(i)]) {
				dfs(visited, list, list[num].get(i));
			}
		}
	}
}
