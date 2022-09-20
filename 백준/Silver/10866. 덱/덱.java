import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> myDeque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				myDeque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				myDeque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (myDeque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(myDeque.pollFirst() + "\n");
				}
				break;
			case "pop_back":
				if (myDeque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(myDeque.pollLast() + "\n");
				}
				break;
			case "size":
				sb.append(myDeque.size() + "\n");
				break;
			case "empty":
				if (myDeque.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (myDeque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(myDeque.getFirst() + "\n");
				}
				break;
			case "back":
				if (myDeque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(myDeque.getLast() + "\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
