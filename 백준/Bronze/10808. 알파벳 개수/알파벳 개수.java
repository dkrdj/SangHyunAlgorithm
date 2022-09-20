import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] A = new int[26];
		for (int i = 0; i < str.length(); i++) {
			A[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			sb.append(A[i] + " ");
		}
		System.out.println(sb);
	}
}