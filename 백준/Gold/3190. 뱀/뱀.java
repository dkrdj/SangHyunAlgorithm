import java.io.*;
import java.util.*;

public class Main {
	static int N, dir, K;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static Deque<Node> snake;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}
		map[1][1] = 1;
		dir = 1;
		int L = Integer.parseInt(br.readLine());
		List<Dir> list = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			list.add(new Dir(x, c));
		}
		snake = new LinkedList<>(); // 1,1에서 우측을 바라보고 있음.
		snake.add(new Node(1, 1));
		int bm = 0;
		for (Dir dir : list) {
			int tmp = move(dir.cost - bm);
			if (tmp != 0) {
				System.out.println(dir.cost - tmp + 1);
				return;
			}
			change(dir.c);
			bm = dir.cost;
		}
		System.out.println(list.get(list.size() - 1).cost + N + 1 - move(N));
	}

	static void change(char c) {
		if (c == 'L') {
			dir += 3;
		} else {
			dir++;
		}
		dir %= 4;
	}

	static int move(int x) {
		int nr = snake.peekFirst().r + dr[dir];
		int nc = snake.peekFirst().c + dc[dir];

		while (x != 0 && wall(nr, nc) && map[nr][nc] != 1) { // x는 남은 횟수
			x--;
			snake.offerFirst(new Node(nr, nc));
			if (map[nr][nc] != 2) {
				Node tail = snake.pollLast();
				map[tail.r][tail.c] = 0;
			}
			map[nr][nc] = 1;
			nr += dr[dir];
			nc += dc[dir];
		}
		return x;
	}

	static boolean wall(int nr, int nc) {
		if (nr > 0 && nr <= N && nc > 0 && nc <= N)
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

class Dir {
	int cost;
	char c;

	public Dir(int cost, char c) {
		this.cost = cost;
		this.c = c;
	}

}