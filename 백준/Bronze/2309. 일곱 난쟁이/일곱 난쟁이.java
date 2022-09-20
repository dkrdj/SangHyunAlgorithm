import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] h = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			h[i] = Integer.parseInt(br.readLine());
			sum += h[i];
		}
		sum = sum - 100;
		int[] ans = new int[7];
		end: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				int hSum = h[i] + h[j];
				if (hSum == sum) {
					for (int k = 0, cnt = 0; k < 9; k++) {
						if (k != i && k != j) {
							ans[cnt++] = h[k];
						}
					}
					break end;
				}
			}
		}
		Arrays.sort(ans);
		for (int i : ans) {
			System.out.println(i);
		}
	}
}