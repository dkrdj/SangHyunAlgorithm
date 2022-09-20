import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> myQueue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				myQueue.add(x);
			}
			else if (str.equals("pop")) {
				if (myQueue.isEmpty()) {
					sb.append("-1\n");
				} else
					sb.append(myQueue.poll()+"\n");
			}
			else if (str.equals("size")) {
				sb.append(myQueue.size() + "\n");
			}
			else if (str.equals("empty")) {
				if (myQueue.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
			else if (str.equals("front")) {
				if (myQueue.isEmpty()) {
					sb.append("-1\n");
				} else
					sb.append(myQueue.peek() + "\n");
			}
			else if (str.equals("back")) {
				if (myQueue.isEmpty()) {
					sb.append("-1\n");
				} else {
					for(int j = 0 ; j < myQueue.size()-1 ; j++) {
						myQueue.add(myQueue.poll());
					}
					sb.append(myQueue.peek()+"\n");
					myQueue.add(myQueue.poll());
				}
			}
		}
		System.out.println(sb);
	}
}
