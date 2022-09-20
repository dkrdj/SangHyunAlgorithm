import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> myStack = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				myStack.push(x);
			} else if (s.equals("pop")) {
				if (myStack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(myStack.pop());
			} else if (s.equals("size")) {
				System.out.println(myStack.size());
			} else if (s.equals("empty")) {
				if (myStack.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			} else if (s.equals("top")) {
				if (myStack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(myStack.peek());
			}
		}
	}
}