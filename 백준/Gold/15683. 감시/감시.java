import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Node> list;
	static int[][] map;
	static int N, M, size;
	static int min = Integer.MAX_VALUE;
	static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6)
					list.add(new Node(i, j));
			}
		}
		list.add(new Node(0, 0));
		size = list.size();
		Node curNode = list.get(0);
		find(curNode.r, curNode.c, 1);
		System.out.println(min);

	}

	static void find(int r, int c, int idx) {
		if (idx == size) {
			min = Math.min(min, sum());
			return;
		}
		switch (map[r][c]) {
		case 1:
			for (int i = 0; i < 4; i++) {
				range(idx, i, r, c);
				Node nxtNode = list.get(idx);
				find(nxtNode.r, nxtNode.c, idx + 1);
				init(idx);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				range(idx, i, r, c);
				range(idx, i + 2, r, c);
				Node nxtNode = list.get(idx);
				find(nxtNode.r, nxtNode.c, idx + 1);
				init(idx);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				range(idx, i, r, c);
				range(idx, (i + 1) % 4, r, c);
				Node nxtNode = list.get(idx);
				find(nxtNode.r, nxtNode.c, idx + 1);
				init(idx);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				range(idx, i, r, c);
				range(idx, (i + 1) % 4, r, c);
				range(idx, (i + 2) % 4, r, c);
				Node nxtNode = list.get(idx);
				find(nxtNode.r, nxtNode.c, idx + 1);
				init(idx);
			}
			break;
		case 5:
			for (int i = 0; i < 4; i++) {
				range(idx, i, r, c);
			}
			Node nxtNode = list.get(idx);
			find(nxtNode.r, nxtNode.c, idx + 1);
			init(idx);
			break;

		default:
			break;
		}

	}

	static void range(int idx, int dir, int r, int c) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		while (checkWall(nr, nc) && map[nr][nc] != 6) {
			if (map[nr][nc] == 0) {
				map[nr][nc] = -idx;
			}
			nr += dr[dir];
			nc += dc[dir];
		}
	}

	static int sum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					sum++;
				}
			}
		}
		return sum;
	}

	static void init(int value) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -value) {
					map[i][j] = 0;
				}
			}
		}
	}

	static boolean checkWall(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
}

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}

}
