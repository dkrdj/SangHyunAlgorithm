import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int bigger = (A > B ? A : B);
		int smaller = (A > B ? B : A);
		int min = 1;
		for (int i = 2; i <= smaller; i++) {
			if (A % i == 0 && B % i == 0) {
				min = i;
			}
		}
		System.out.println(min);
		System.out.println(bigger * smaller / min);
	}
}
