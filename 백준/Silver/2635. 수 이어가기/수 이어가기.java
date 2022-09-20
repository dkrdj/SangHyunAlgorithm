import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<Integer> ansList = null;

		int max = 0;

		for (int i = 1; i <= N; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);
			int j = 2;
			while (list.get(j - 2) - list.get(j - 1) >= 0) {
				list.add(list.get(j - 2) - list.get(j - 1));
				j++;
			}
			if (j > max) {
				max = j;
				ansList = list;
			}
		}

		sb.append(max + "\n");

		for (int i : ansList) {
			sb.append(i + " ");
		}

		System.out.println(sb);

	}

}