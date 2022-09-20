import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.age != o2.age)
					return o1.age - o2.age;
				else
					return o1.seq - o2.seq;

			}

		});
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i).age + " " + list.get(i).name + "\n");
		}
		System.out.println(sb.toString());
	}

}

class Node {
	int age;
	int seq;
	String name;

	public Node() {
	}

	public Node(int age, String name, int seq) {
		this.age = age;
		this.seq = seq;
		this.name = name;
	}
}