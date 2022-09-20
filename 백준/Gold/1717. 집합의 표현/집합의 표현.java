import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = i;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sort = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (sort == 0)
				merge(a, b);
			else {
				if (isContain(a, b))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}

		}
		System.out.println(sb);
	}

	static boolean isContain(int a, int b) {
		if (arr[a] != a)
			a = find(arr[a]);
		if (arr[b] != b)
			b = find(arr[b]);
		if (a != b)
			return false;
		else
			return true;
	}

	static void merge(int a, int b) {
		arr[find(b)] = find(a);
	}

	static int find(int a) {
		if (arr[a] == a)
			return a;
		else
			arr[a] = find(arr[a]);
		return arr[a];
	}
}