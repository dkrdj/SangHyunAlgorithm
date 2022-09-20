import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();

		int x = (p + t) % (2 * w);
		int y = (q + t) % (2 * h);
		System.out.println(Math.min(x, 2 * w - x) + " " + Math.min(y, 2 * h - y));
	}
}