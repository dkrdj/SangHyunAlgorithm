import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = str.length();
		if (N % 3 != 0) {
			int first = Integer.parseInt(str.substring(0, N % 3));
			sb.append(toEight(first));
		}
		for (int i = N % 3; i + 3 <= N; i += 3) {
			int tmp = Integer.parseInt(str.substring(i, i + 3));
			sb.append(toEight(tmp));
		}
		System.out.println(sb);
	}

	static int toEight(int num) {
		int tmp1 = num / 100;
		int tmp2 = (num - tmp1 * 100) / 10;
		int tmp3 = num % 10;
		return tmp1 * 4 + tmp2 * 2 + tmp3;
	}
}