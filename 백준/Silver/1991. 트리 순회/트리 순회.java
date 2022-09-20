import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 'A';
			String str = st.nextToken();
			if (!str.equals(".")) {
				int left = str.charAt(0) - 'A';
				graph[root][0] = left;
			}
			str = st.nextToken();
			if (!str.equals(".")) {
				int right = str.charAt(0) - 'A';
				graph[root][1] = right;
			}
		}

		pretra(0);
		sb.append("\n");
		intra(0);
		sb.append("\n");
		postra(0);
		System.out.println(sb);

	}

	static void pretra(int start) {
		sb.append((char) (start + 'A'));
		for (int i = 0; i < 2; i++) {
			if (graph[start][i] != 0) {
				pretra(graph[start][i]);
			}
		}
	}

	static void intra(int start) {
		if (graph[start][0] != 0)
			intra(graph[start][0]);
		sb.append((char) (start + 'A'));
		if (graph[start][1] != 0)
			intra(graph[start][1]);
	}

	static void postra(int start) {
		for (int i = 0; i < 2; i++) {
			if (graph[start][i] != 0) {
				postra(graph[start][i]);
			}
		}
		sb.append((char) (start + 'A'));
	}

}