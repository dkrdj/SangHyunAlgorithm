import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 5; i <= N; i += 5) {
			int tmp = i ;
			while (tmp % 5 == 0) {
				tmp /= 5;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
