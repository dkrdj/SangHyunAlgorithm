import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> myStack = new Stack<>();
		List<Node> list = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (h > max) {
				max = h;
			}
			list.add(new Node(l, h));
		}
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.l - o2.l;
			}
		});
		int[] graph = new int[list.get(list.size() - 1).l - list.get(0).l + 1];
		int start = list.get(0).l;
		for (int i = 0; i < list.size(); i++) {
			graph[list.get(i).l - start] = list.get(i).h;
		}
		myStack.add(graph[0]);
		boolean isExistMax = false;
		for (int i = 1; i < graph.length; i++) {
			if (isExistMax) {
				if (graph[i] <= myStack.peek()) {
					myStack.add(graph[i]);
				} else {
					int cnt = 1;
					while (myStack.peek() < graph[i]) {
						myStack.pop();
						cnt++;
					}
					while (cnt-- != 0) {
						myStack.add(graph[i]);
					}
				}
			} else {
				if (graph[i] > myStack.peek()) {
					myStack.add(graph[i]);
				} else {
					myStack.add(myStack.peek());
				}
				if (myStack.peek() == max) {
					isExistMax = true;
				}
			}
		}
		int sum = 0;
		for (int i : myStack) {
			sum += i;
		}
		System.out.println(sum);
	}
}

class Node {
	int l;
	int h;

	public Node(int l, int h) {
		this.l = l;
		this.h = h;
	}
}