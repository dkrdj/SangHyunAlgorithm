import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		permu(arr, new int[N], 0, 0);
		System.out.println(max);
	}

	static void permu(int[] arr, int[] resArr, int pick, int cnt) {
		if (cnt == N) {
			max = Math.max(max, sum(resArr, 0, N));
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((pick & (1 << i)) == 0) {
				int newPick = pick | (1 << i);
				resArr[cnt] = arr[i];
				permu(arr, resArr, newPick, cnt + 1);
			}

		}
	}

	static int sum(int[] arr, int start, int end) {
		if (start == arr.length - 2)
			return Math.abs(arr[start] - arr[start + 1]);
		else {
			return Math.abs(arr[start] - arr[start + 1]) + sum(arr, start + 1, end);
		}
	}

}