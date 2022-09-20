import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[n + 1];

		if (n <= 1) {
			System.out.println("0");
			return;
		}

		arr[1] = 0;
		arr[2] = 1;
		for (int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) * (i - 1);
			arr[i] %= 1000000000;
		}

		System.out.println(arr[n]);
	}

}