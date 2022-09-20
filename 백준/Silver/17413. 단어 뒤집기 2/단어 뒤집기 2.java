import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> myStack = new Stack<>();
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ' && str.charAt(i) != '<') {
				myStack.add(str.charAt(i));
			} // 빈칸이나 꺽쇠 나오기 전까지 계속 스택에 더함
			else if (str.charAt(i) == '<') {//꺽쇠일때
				while (!myStack.isEmpty()) {
					sb.append(myStack.pop());
				}
				while (str.charAt(i) != '>') {
					sb.append(str.charAt(i++));
				}
				sb.append(str.charAt(i));// > 더해줌
			}
			else {//공백일때
				while (!myStack.isEmpty()) {
					sb.append(myStack.pop());
				}
				sb.append(str.charAt(i));
			}
		}
		while (!myStack.isEmpty()) {
			sb.append(myStack.pop());
		}
		System.out.print(sb);
	}
}
