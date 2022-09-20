import java.io.*;
import java.util.*;

public class Main {
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new LinkedList[N + 1];
		boolean[] visited = new boolean[N + 1];
		seq = new int[N+1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(list[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
		}
		bfs(visited, list, R);
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < N+1;i++) {
			sb.append(seq[i]+"\n");
		}
		System.out.print(sb);
	}

	static void bfs(boolean[] visited, List<Integer>[] list, int R) {
		visited[R] = true;
		int cnt =1;
		seq[R]=cnt++;
		Queue<Integer> myQueue = new LinkedList<>();
		myQueue.add(R);
		while (!myQueue.isEmpty()) {
			R = myQueue.poll();
			ListIterator<Integer> iter = list[R].listIterator();
			while (iter.hasNext()) {
				int w = iter.next();
				if (!visited[w]) {
					visited[w] = true;
					seq[w]=cnt++;
					myQueue.add(w);
				}
			}
		}
	}
}
