import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int len = str.length();
		Stack<Character> myStack1 = new Stack<>();
		Stack<Character> myStack2 = new Stack<>();
		for (int i = 0; i < len; i++) {
			myStack1.add(str.charAt(i));
		}
		int N = Integer.parseInt(br.readLine());
		for (int j = 0; j < N; j++) {
			String s = br.readLine();
			switch (s.charAt(0)) {
			case 'L':
				if (!myStack1.isEmpty())
					myStack2.add(myStack1.pop());
				break;
			case 'D':
				if (!myStack2.isEmpty())
					myStack1.add(myStack2.pop());
				break;
			case 'B':
				if (!myStack1.isEmpty()) {
					myStack1.pop();
				}
				break;
			case 'P':
				myStack1.add(s.charAt(2));
			}
		}
		while(!myStack1.isEmpty()) {
			sb.append(myStack1.pop());
		}
		sb.reverse();
		while(!myStack2.isEmpty()) {
			sb.append(myStack2.pop());
		}
		System.out.println(sb);
	}
}