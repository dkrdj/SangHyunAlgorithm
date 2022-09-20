import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[] f = new long[101];
		f[1] = 1;
		f[2] = 1;
		f[3] = 1;
		f[4] = 2;
		f[5] = 2;
		for (int i = 6; i <= 100; i++) {
			f[i] = f[i - 1] + f[i - 5];
		}
		for (int t = 0; t < T; t++) {
			sb.append(f[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}

}