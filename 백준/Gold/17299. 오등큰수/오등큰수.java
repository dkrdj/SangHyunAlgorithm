import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> myStack = new Stack<>();
		int[] A = new int[N];
		int[] F = new int[1000001];
		int[] ans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			F[A[i]]++;
		}
		myStack.push(0);
		for (int i = 1; i < N; i++) {

			while (!myStack.isEmpty() && F[A[myStack.peek()]] < F[A[i]]) {
				ans[myStack.pop()] = A[i];
			}
			myStack.push(i);
		}
		while(!myStack.isEmpty()) {
			ans[myStack.pop()] = -1;
		}
		for(int i : ans) {
			sb.append(i+" ");
		}
		System.out.println(sb);

	}
}
