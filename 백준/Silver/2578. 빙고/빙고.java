import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] A = new int[25];
		int[] B = new int[26];
		int[] ver = new int[5];
		int[] ho = new int[5];
		int[] di = new int[2];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				A[5 * i + j] = tmp;
				B[tmp] = 5 * i + j;
			}
		}
		int cnt = 0;
		int bingo = 0;
		end: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				cnt++;
				if (++ver[B[tmp] % 5] == 5)
					bingo++;
				if (++ho[B[tmp] / 5] == 5)
					bingo++;
				if (B[tmp] % 6 == 0)
					if (++di[0] == 5)
						bingo++;
				if (B[tmp] % 4 == 0 && B[tmp] != 0 && B[tmp] != 24)
					if (++di[1] == 5)
						bingo++;
				if (bingo >= 3)
					break end;
			}
		}
		System.out.println(cnt);
	}
}