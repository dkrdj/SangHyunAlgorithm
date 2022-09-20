import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int mid = N - M;
		int cnt1 = get5(N)-get5(M)-get5(mid);
		int cnt2 = get2(N)-get2(M)-get2(mid);
		System.out.println(Math.min(cnt1, cnt2));
	}

	static int get5(int num) {
		int cnt = 0;
		while (num >= 5) {
			cnt += num / 5;
			num /= 5;
		}
		return cnt;
	}
	
	static int get2(int num) {
		int cnt = 0;
		while (num >= 2) {
			cnt += num / 2;
			num /= 2;
		}
		return cnt;
	}
}
