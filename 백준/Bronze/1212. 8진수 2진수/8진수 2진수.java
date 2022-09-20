import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		if (str.charAt(0) >= '4') {
			sb.append(toTwo(str.charAt(0)));
		} else if (str.charAt(0) >= '2') {
			sb.append(toTwo(str.charAt(0)).substring(1));
		} else {
			sb.append(toTwo(str.charAt(0)).substring(2));
		}
		for (int i = 1; i < str.length(); i++) {
			sb.append(toTwo(str.charAt(i)));
		}
		System.out.println(sb);
	}

	static String toTwo(char c) {
		int num = c - '0';
		int tmp1 = num / 4;
		int tmp2 = (num / 2) % 2;
		int tmp3 = num % 2;
		return String.valueOf(tmp1) + String.valueOf(tmp2) + String.valueOf(tmp3);
	}
}