import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		int[] A = new int[26];
		// A = 65, Z = 90

		for (int i = 0; i < str.length(); i++) {
			A[(int) str.charAt(i) - 65]++;
		}
		int ans = 0;
		int idx = 0;
		int check = -1;
		for (int i = 0; i < 26; i++) {
			if (ans < A[i]) {
				ans = A[i];
				idx = i;
			} else if (ans == A[i])
				check = i;
		}
		if (check != -1 && A[check] == A[idx])
			System.out.println("?");
		else
			System.out.println((char)(idx+65));
	}
}