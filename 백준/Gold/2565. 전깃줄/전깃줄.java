import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int top1 = Integer.parseInt(st.nextToken());
			int top2 = Integer.parseInt(st.nextToken());
			arr[i][0] = top1;
			arr[i][1] = top2;
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		int[] ansArr = new int[N];
		ansArr[0] = arr[0][1];
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i][1] < ansArr[cnt - 1]) {
				ansArr[binarySearch(ansArr, 0, cnt - 1, arr[i][1])] = arr[i][1];
			} else {
				ansArr[cnt++] = arr[i][1];
			}
		}
		System.out.println(N - cnt);

	}

	static int binarySearch(int[] arr, int start, int end, int value) {
		if (end - start <= 1 && arr[start] > value) {
			return start;
		} else if (value > arr[(start + end) / 2]) {
			return binarySearch(arr, (start + end) / 2 + 1, end, value);
		} else {
			return binarySearch(arr, start, (start + end) / 2 - 1, value);
		}
	}

}