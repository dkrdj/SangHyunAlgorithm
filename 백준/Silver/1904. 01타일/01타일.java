import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println("1");
			return;
		}

		// 피보나치

		int[] f = new int[n + 1];

		f[1] = 1;
		f[2] = 2;
		for (int i = 3; i <= n; i++) {
			f[i] = f[i - 1] % 15746 + f[i - 2] % 15746;
		}

		System.out.println(f[n] % 15746);

	}

}