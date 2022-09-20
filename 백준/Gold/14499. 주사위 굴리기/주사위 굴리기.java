import java.io.*;
import java.util.*;

public class Main {
//9.35
	static int N, M, x, y;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static Dice dice;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dice = new Dice(0, 0, 0, 0, 0, 0);
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(st.nextToken());
			move(order);
		}
		System.out.println(sb);

	}

	static void move(int dir) { // 1234 동서북남 x는 r y는 c
		x += dr[dir - 1];
		y += dc[dir - 1];
		if (x >= 0 && x < N && y >= 0 && y < M) {

			if (dir == 1) {
				dice.right();
			} else if (dir == 2) {
				dice.left();
			} else if (dir == 3) {
				dice.up();
			} else {
				dice.down();
			}
			if (map[x][y] == 0)
				map[x][y] = dice.behind;
			else {
				dice.behind = map[x][y];
				map[x][y] = 0;
			}
			sb.append(dice.main).append("\n");
		} else {
			x -= dr[dir - 1];
			y -= dc[dir - 1];
		}
	}

}

class Dice {
	int main;
	int top;
	int bottom;
	int left;
	int right;
	int behind;

	public Dice(int main, int top, int bottom, int left, int right, int behind) {
		this.main = main;
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.behind = behind;
	}

	public void right() {
		int tmp = main;
		main = left;
		left = behind;
		behind = right;
		right = tmp;
	}

	public void left() {
		int tmp = main;
		main = right;
		right = behind;
		behind = left;
		left = tmp;
	}

	public void up() {
		int tmp = main;
		main = bottom;
		bottom = behind;
		behind = top;
		top = tmp;
	}

	public void down() {
		int tmp = main;
		main = top;
		top = behind;
		behind = bottom;
		bottom = tmp;
	}

}