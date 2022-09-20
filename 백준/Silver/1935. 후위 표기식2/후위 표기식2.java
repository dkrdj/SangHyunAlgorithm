import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Stack<Double> myStack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '*':
				myStack.add(myStack.pop() * myStack.pop());
				break;
			case '+':
				myStack.add(myStack.pop() + myStack.pop());
				break;
			case '-':
				myStack.add(-myStack.pop() + myStack.pop());
				break;
			case '/':
				myStack.add(1 / myStack.pop() * myStack.pop());
				break;
			default:
				myStack.add((double) A[(str.charAt(i) - 'A')]);
			}
		}
		System.out.println(String.format("%.2f", myStack.pop()));
	}
}