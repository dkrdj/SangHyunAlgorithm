import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (isSame(a, b)) {
				System.out.println(i);
				return;
			} else {
				union(a, b);
			}
		}
		System.out.println("0");
	}

	static void union(int a, int b) {
		arr[find(b)] = find(a);
	}

	static int find(int a) {
		if (arr[a] == a)
			return a;
		else {
			return arr[a] = find(arr[a]);
		}
	}

	static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}
}
