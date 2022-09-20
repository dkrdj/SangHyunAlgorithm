import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] c = new char[str.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = str.charAt(i);
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j + 1 < c.length - i; j++) {
				if (c[j] < c[j + 1]) {
					char tmp = c[j];
					c[j] = c[j + 1];
					c[j + 1] = tmp;
				}
			}
		}
		for (char ch : c) {
			System.out.print(ch);
		}

	}

}