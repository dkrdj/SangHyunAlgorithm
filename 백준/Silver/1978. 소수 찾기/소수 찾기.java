import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		list.add(2);
		for (int i = 3; i <= 1000; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i % list.get(j) == 0) {
					break;
				}
				if (j == list.size() - 1) {
					list.add(i);
				}
			}
		}
		int[] A = new int[1001];
		for (int i = 0; i < list.size(); i++) {
			A[list.get(i)]++;
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (A[sc.nextInt()] == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
