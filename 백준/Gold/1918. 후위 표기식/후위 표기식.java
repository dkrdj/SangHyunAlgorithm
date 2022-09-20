import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		Stack<Character> myStack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A') { // 알파뱃일경우
				sb.append(c);
			} else if (c == '(') {
				myStack.add(c);
			} else if (c == '+' || c == '-') {
				while (!myStack.isEmpty() && myStack.peek() != '(') {
					sb.append(myStack.pop());
				}
				myStack.add(c);
			} else if (c == '*' || c == '/') { // 더하기 빼기
				while (!myStack.isEmpty() && (myStack.peek() == '*' || myStack.peek() == '/')) {
					sb.append(myStack.pop());
				}

				myStack.add(c);
			} else {
				while (myStack.peek() != '(') {
					sb.append(myStack.pop());
				}
				myStack.pop();
			}
		}
		while (!myStack.isEmpty())

		{
			sb.append(myStack.pop());
		}
		System.out.println(sb);
	}
}