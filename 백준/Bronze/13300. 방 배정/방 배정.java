import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] arr = new int[2][7];

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[gender][grade]++;
		}

		int cnt = 12;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				if (arr[i][j] == 0)
					cnt--;
				else if (arr[i][j] > k)
					cnt += (arr[i][j] - 1) / k;
			}
		}
		System.out.println(cnt);

	}

}