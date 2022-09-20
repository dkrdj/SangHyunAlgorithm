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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cnt = 1;
			int F = Integer.parseInt(br.readLine());
			arr = new int[F * 2 + 1];
			Map<String, Integer> myMap = new HashMap<>();
			int[] size = new int[F * 2 + 1];
			for (int i = 1; i < F * 2 + 1; i++) {
				size[i] = 1;
			}
			for (int i = 1; i <= F; i++) {
				st = new StringTokenizer(br.readLine());
				String p1 = st.nextToken();
				String p2 = st.nextToken();

				if (!myMap.containsKey(p1)) {
					myMap.put(p1, cnt);
					arr[cnt] = cnt++;
				}
				if (!myMap.containsKey(p2)) {
					myMap.put(p2, cnt);
					arr[cnt] = cnt++;
				}
				int idx1 = myMap.get(p1);
				int idx2 = myMap.get(p2);
				if (!sameUnion(idx1, idx2)) {
					size[find(idx1)] += size[find(idx2)];
					union(myMap.get(p1), myMap.get(p2));
				}
				sb.append(size[find(idx1)]).append("\n");
			}
		}
		System.out.println(sb);

	}

	static int find(int idx) {
		if (idx == arr[idx])
			return idx;
		else
			return arr[idx] = find(arr[idx]);
	}

	static void union(int a, int b) {
		arr[find(b)] = find(a);
	}

//	static int unionSize(int idx) {
//		int size = 0;
//		for (int i = 1; i < cnt; i++) {
//			if (find(arr[i]) == find(idx))
//				size++;
//		}
//		return size;
//	}

	static boolean sameUnion(int a, int b) {
		return find(a) == find(b);
	}
}
