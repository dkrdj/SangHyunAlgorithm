import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[10];
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j >= 10) {
				A[j % 10]++;
				j /= 10;
			}
			A[j]++;
		}
		int d = sc.nextInt();
		System.out.println(A[d]);
	}
}