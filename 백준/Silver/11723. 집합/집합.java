import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		boolean[] s = new boolean[21];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens())
				x = Integer.parseInt(st.nextToken());
			switch (str) {
			case "add":
				s[x] = true;
				break;
			case "remove":
				s[x] = false;
				break;
			case "check":
				sb.append(s[x] ? "1" : "0").append("\n");
				break;
			case "toggle":
				s[x] ^= true;
				break;
			case "all":
				for (int j = 1; j <= 20; j++)
					s[j] = true;
				break;
			case "empty":
				s = new boolean[21];
				break;
			default:
				break;
			}
		}
		System.out.println(sb);

	}

}
