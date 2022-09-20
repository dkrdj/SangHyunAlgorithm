import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[5];
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int x = 0, y = 0;
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			x += dr[dir - 1] * dis;
			y += dc[dir - 1] * dis;
			list.add(new Node(x, y));
		}

		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {

				return o1.x - o2.x;
			}

		});
		int maxrow = list.get(0).x - list.get(5).x;
		int mincol = list.get(2).y - list.get(3).y;

		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {

				return o1.y - o2.y;
			}

		});
		int maxcol = list.get(0).y - list.get(5).y;
		int minrow = list.get(2).x - list.get(3).x;

		int ans = Math.abs(maxrow * maxcol) - Math.abs(minrow * mincol);
		System.out.println(ans * n);

	}
}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
