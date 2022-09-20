import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N, -1, 1);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	public static void hanoi(int N, int start, int end) {
		if (N == 1) {
			sb.append((start + 2) + " " + (end + 2)+"\n");
			cnt++;
		} else {
			hanoi(N - 1, start, -(start + end));
			sb.append((start + 2) + " " + (end + 2)+"\n");
			cnt++;
			hanoi(N - 1, -(start + end), end);
		}
	}
}