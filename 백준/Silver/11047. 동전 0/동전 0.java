import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0;
		while (K != 0) {
			int cnt = 0;
			while (cnt < N) {
				if (K / A[cnt] == 0)
					break;
				cnt++;
			}
			sum += (K / A[cnt - 1]);
			K %= A[cnt - 1];
		}
		System.out.println(sum);
	}
}