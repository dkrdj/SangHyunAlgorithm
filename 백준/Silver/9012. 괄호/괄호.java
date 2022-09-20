import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			boolean VPS = true;
			int ans = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j)=='(') {
					ans++;
				} else {
					ans--;
				}
				if (ans < 0) {
					VPS = false;
					break;
				}
			}
			if (VPS && ans==0)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}
}