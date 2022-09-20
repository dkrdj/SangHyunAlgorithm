import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.x != o2.x)
					return o1.x - o2.x;
				else
					return o1.y - o2.y;
			}

		});
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
	}

}

class Node {
	int x;
	int y;

	public Node() {
	}

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}