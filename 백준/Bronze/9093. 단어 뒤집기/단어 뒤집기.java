import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				String s = st.nextToken();
				for (int j = s.length() - 1; j >= 0; j--) {
					sb.append(s.charAt(j));
				}
				sb.append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}
}