import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		if (Integer.parseInt(st.nextToken()) == 1) {
			long num = Long.parseLong(st.nextToken()) - 1;
			for (int i = N - 1; i >= 0; i--) {
				long idx = num / factorial(i);
				System.out.print(list.get((int) idx) + " ");
				list.remove((int) idx);
				num -= idx * factorial(i);
			}
		} else {
			long sum = 0;
			for (int i = 1; i <= N; i++) {
				long tmp = list.indexOf(Integer.parseInt(st.nextToken()));
				sum += tmp * factorial(N - i);
				list.remove((int) tmp);
			}
			System.out.println(sum + 1);
		}
	}

	static long factorial(int N) {
		long ans = 1;
		for (int i = 1; i <= N; i++) {
			ans *= i;
		}
		return ans;
	}

}