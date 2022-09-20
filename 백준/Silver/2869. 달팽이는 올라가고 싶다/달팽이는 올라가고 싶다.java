import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int cnt = (V - A) / (A - B);
		if ((V - A) % (A - B) == 0) {
			System.out.println(cnt+1);
		} else {
			System.out.println(cnt+2);
		}
	}
}