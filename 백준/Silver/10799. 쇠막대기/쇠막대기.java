import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> myStack = new Stack<>();
		String str = br.readLine();
		int ans = 0;
		for (int i = 0, cnt = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				if (myStack.peek() == '(') {
					myStack.add(str.charAt(i));
					cnt++;
					ans += (myStack.size() - 2 * cnt);
				} else {
					myStack.add(str.charAt(i));
					ans++;
					cnt++;
				}
			} else
				myStack.add(str.charAt(i));
		}
		System.out.println(ans);
	}
}
