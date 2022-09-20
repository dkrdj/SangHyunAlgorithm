import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int intiN = Integer.parseInt(s) - s.length() * 9;
		boolean isans = false;
		for (int i = 0; i <= s.length() * 9; i++) {
			int ans = intiN + i;
			for (int j = 0; j < String.valueOf(intiN + i).length(); j++) {
				ans += String.valueOf(intiN + i).charAt(j) - '0';
			}
			if (ans == Integer.parseInt(s)) {
				isans = true;
				System.out.println(intiN + i);
				break;
			}
		}
		if (!isans)
			System.out.println("0");

	}
}