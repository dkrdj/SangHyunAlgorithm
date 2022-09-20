import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int N, M, r_r, r_c, b_r, b_c;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					r_r = i;
					r_c = j;
				} else if (map[i][j] == 'B') {
					b_r = i;
					b_c = j;
				}
			}
		}
		int ans = bfs();
		if (ans == 0)
			System.out.println("-1");
		else
			System.out.println(ans);
	}

	static int bfs() {
		Set<Node> mySet = new HashSet<>();
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(r_r, r_c, b_r, b_c, 0));
		while (!que.isEmpty()) {
			Node curNode = que.poll();
			if (curNode.rr == N)
				return curNode.cnt;
			if (curNode.rr == -1)
				continue;
			if (curNode.cnt == 11)
				break;
			for (int i = 0; i < 4; i++) {
				Node nxtNode = gravity(curNode, i);
				if (nxtNode != null && !mySet.contains(nxtNode)) {
					mySet.add(nxtNode);
					que.offer(nxtNode);
				}
			}
		}
		return 0;
	}

	static Node gravity(Node node, int dir) {
		int nrr = node.rr + dr[dir];
		int nrc = node.rc + dc[dir];
		int nbr = node.br + dr[dir];
		int nbc = node.bc + dc[dir];
		while (map[nrr][nrc] != '#' && map[nrr][nrc] != 'O') {
			nrr += dr[dir];
			nrc += dc[dir];
		}
		while (map[nbr][nbc] != '#' && map[nbr][nbc] != 'O') {
			nbr += dr[dir];
			nbc += dc[dir];
		}
		if (map[nbr][nbc] == 'O')
			return new Node(-1, -1, -1, -1, node.cnt + 1);
		if (map[nrr][nrc] == 'O')
			return new Node(N, N, N, N, node.cnt + 1);
		if (nrr == nbr && nrc == nbc) {
			if (dir == 0) {
				if (node.rr > node.br)
					nrr -= dr[dir];
				else
					nbr -= dr[dir];
			} else if (dir == 1) {
				if (node.rc > node.bc)
					nbc -= dc[dir];
				else
					nrc -= dc[dir];
			} else if (dir == 2) {
				if (node.rr < node.br)
					nrr -= dr[dir];
				else
					nbr -= dr[dir];
			} else if (dir == 3) {
				if (node.rc < node.bc)
					nbc -= dc[dir];
				else
					nrc -= dc[dir];
			}
		}
		nrr -= dr[dir];
		nrc -= dc[dir];
		nbr -= dr[dir];
		nbc -= dc[dir];
		return new Node(nrr, nrc, nbr, nbc, node.cnt + 1);
	}
}

class Node {
	int rr;
	int rc;
	int br;
	int bc;
	int cnt;

	public Node(int rr, int rc, int br, int bc, int cnt) {
		this.rr = rr;
		this.rc = rc;
		this.br = br;
		this.bc = bc;
		this.cnt = cnt;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Node) {
			Node tmp = (Node) obj;
			if (tmp.rr == this.rr && tmp.rc == this.rc && tmp.br == this.br && tmp.bc == this.bc)
				return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		return this.rr + this.rc + this.br + this.bc;

	}
}