import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp > 0) {
				plusQueue.add(tmp);
			} else {
				minusQueue.add(tmp);
			}
		}
		int sum = 0;
		while (plusQueue.size() > 1) {
			int tmp1 = plusQueue.poll();
			if (tmp1 > 1) {
				int tmp2 = plusQueue.poll();
				if (tmp2 > 1) {
					sum += tmp1 * tmp2;
				} else {
					sum += tmp1 + tmp2;
				}
			} else {
				sum += tmp1;
				break;
			}
		}
		while (!plusQueue.isEmpty()) {
			sum += plusQueue.poll();
		}
		while (minusQueue.size() > 1) {
			sum += minusQueue.poll() * minusQueue.poll();
		}
		while (!minusQueue.isEmpty()) {
			sum += minusQueue.poll();
		}
		System.out.println(sum);
	}
}