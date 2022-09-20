import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		int x = 1;
		int y = 1;

		if (k > c * r) {
			System.out.println("0");
			return;
		}

		while (true) {
			k -= (2 * c + 2 * r - 4);
			if (k <= 0) {
				k += (2 * c + 2 * r - 4);
				break;
			}
			c -= 2;
			r -= 2;
			x++;
			y++;
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		k--;

		int initX = 0;
		int initY = 0;

		for (int i = 0; i < 4; i++) {
			while (k > 0) {
				int nx = initX + dx[i];
				int ny = initY + dy[i];
				if (nx < 0 || nx >= c || ny < 0 || ny >= r)
					break;
				k--;
				initX = nx;
				initY = ny;
			}
		}

		System.out.println((x + initX) + " " + (y + initY));

	}

}