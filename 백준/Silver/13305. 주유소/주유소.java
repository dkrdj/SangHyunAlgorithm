import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] len = new int[N];
		int[] price = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		long before = price[0];
		long sum = 0;
		for (int i = 1; i < N; i++) {
			sum += before * len[i-1];
			if (price[i] <= before) {
				before = price[i];
			}
		}
		System.out.println(sum);
	}
}