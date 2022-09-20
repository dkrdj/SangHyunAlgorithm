import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				st.nextToken();
			}
			for (int j = i + 1; j <= n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1)
					union(i, j);
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		boolean isConnected = true;
		while (st.hasMoreTokens()) {
			int b = Integer.parseInt(st.nextToken());
			if (!check(a, b)) {
				isConnected = false;
				break;
			}
			a = b;
		}
		if (isConnected)
			System.out.println("YES");
		else
			System.out.println("NO");

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

	static boolean check(int a, int b) {
		if (find(a) == find(b))
			return true;
		return false;
	}
}