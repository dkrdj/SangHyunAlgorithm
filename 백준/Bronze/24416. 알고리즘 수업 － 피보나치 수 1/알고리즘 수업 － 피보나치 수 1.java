import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibo(n) + " " + (n - 2));

	}

	static long fibo(int n) {
		long[] f = new long[n + 1];
		f[1] = 1;
		f[2] = 1;
		for (int i = 3; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

}