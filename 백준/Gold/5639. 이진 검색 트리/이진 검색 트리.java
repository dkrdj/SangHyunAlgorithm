import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static int[] posto;
	static int cnt = 0;
	static int root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		list.add(0);
		while ((str = br.readLine()) != null && !str.equals("")) {
			list.add(Integer.parseInt(str));
		}

		int n = list.size();
		posto = new int[n];

		postOrder(1, n - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			sb.append(posto[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void postOrder(int preS, int preE) {
		if (preS == preE) {
			posto[cnt++] = list.get(preS);
			return;
		}
		int idx = preS;
		for (int i = preS + 1; i <= preE; i++) {
			if (list.get(i) > list.get(preS)) {
				idx = i;
				break;
			}
		}
		if (idx <= preS + 1) {
			postOrder(preS + 1, preE);
		} else {
			postOrder(preS + 1, idx - 1);
			postOrder(idx, preE);
		}
		posto[cnt++] = list.get(preS);
	}

}