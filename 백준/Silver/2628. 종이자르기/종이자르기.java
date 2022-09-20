import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		List<Integer> rowList = new ArrayList<>();
		List<Integer> colList = new ArrayList<>();
		rowList.add(0);
		rowList.add(r);
		colList.add(0);
		colList.add(c);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			if (tmp == 0)
				colList.add(val);
			else
				rowList.add(val);
		}
		Collections.sort(rowList);
		Collections.sort(colList);

		int max = 0;

		for (int i = rowList.size() - 1; i > 0; i--) {
			int row = rowList.get(i) - rowList.get(i - 1);
			for (int j = colList.size() - 1; j > 0; j--) {
				int col = colList.get(j) - colList.get(j - 1);
				if (col * row > max)
					max = col * row;
			}
		}

		System.out.println(max);
	}

}
