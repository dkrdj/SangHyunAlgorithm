import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] arr = new int[V + 1][V + 1];
		for (int[] a : arr)
			Arrays.fill(a, Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = c;
		}

		for (int i = 1; i <= V; i++)
			for (int j = 1; j <= V; j++)
				for (int k = 1; k <= V; k++)
					if (arr[j][i] < Integer.MAX_VALUE && arr[i][k] < Integer.MAX_VALUE)
						arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++)
			min = Math.min(min, arr[i][i]);
		if (min != Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println(-1);

	}

}