import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String str = Integer.toString(A*B*C);
		int[] num = new int[10];
		for(int i = 0 ; i < str.length() ; i++) {
			num[str.charAt(i)-'0']++;
		}
		for(int i : num) {
			System.out.println(i);
		}
	}
}