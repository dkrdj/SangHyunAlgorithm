import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		// N이 9일경우 0000 1000 1010 1001 0100 0101
		int max = Integer.MIN_VALUE;
		outer: for (int i = 0; i < (1 << N / 2); i++) {
			for (int j = 0; j < N / 2; j++) {
				if ((i & (1 << j)) != 0) {
					if ((j - 1 < 0 || (i & (1 << (j - 1))) == 0) && (j + 1 >= N / 2 || (i & (1 << (j + 1))) == 0)) {
						continue;
					} else {
						continue outer;
					}
				}
			}
			max = Math.max(max, preCalc(str, i));
		}
		System.out.println(max);
	}

	static int preCalc(String str, int idx) {
		Queue<Integer> nQue = new LinkedList<>();
		Queue<Character> cQue = new LinkedList<>();
		for (int i = 0; i < str.length() / 2; i++) {
			if ((idx & (1 << i)) == 0) {
				nQue.offer(str.charAt(2 * i) - '0');
				cQue.offer(str.charAt(2 * i + 1));
			} else {
				int a = str.charAt(2 * i) - '0';
				int b = str.charAt(2 * i + 2) - '0';
				char c = str.charAt(2 * i + 1);
				nQue.offer(calc(a, b, c));
				if (i != str.length() / 2 - 1)
					cQue.offer(str.charAt(2 * i + 3));
				i++;
			}
		}
		nQue.offer(str.charAt(str.length() - 1) - '0');
		int ans = nQue.poll();
		while (!cQue.isEmpty()) {
			int b = nQue.poll();
			char c = cQue.poll();
			ans = calc(ans, b, c);
		}
		return ans;
	}

	static int calc(int a, int b, char c) {
		switch (c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;

		default:
			return 0;
		}
	}
}
