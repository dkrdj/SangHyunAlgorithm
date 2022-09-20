import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Node(Integer.parseInt(st.nextToken()), i));
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.x - o2.x;
			}
		});

		int[] A = new int[N];
		A[list.get(0).seq] = 0;
		for (int i = 1, cnt = 1; i < N; i++) {
			if (list.get(i).x == list.get(i - 1).x)
				A[list.get(i).seq] = A[list.get(i - 1).seq];
			else
				A[list.get(i).seq] = cnt++;
		}
		for (int i = 0; i < N; i++) {
			sb.append(A[i] + " ");
		}
		System.out.println(sb.toString());
	}
}

class Node {
	int x;
	int seq;

	Node(int x, int seq) {
		this.x = x;
		this.seq = seq;
	}
}