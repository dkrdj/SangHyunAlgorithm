import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		arr = new int[N * M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		for (int i = 1; i <= N * M; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					search(i, j);
				else {
					arr[M * i + j + 1] = 0;
				}
			}
		}
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < M; l++) {
							if (map[k][l] == 1) {
								if ((i == k || j == l) && !(i == k && j == l)) {
									if (!isSame(M * i + j + 1, M * k + l + 1)) {
										if (i == k && l > j) {
											boolean isone = false;
											for (int ii = j + 1; ii < l; ii++) {
												if (map[i][ii] == 1) {
													isone = true;
													break;
												}
											}
											if (!isone)
												list.add(new Node(M * i + j + 1, M * k + l + 1, l - j - 1));
										} else if (j == l && k > i) {
											boolean isone = false;
											for (int ii = i + 1; ii < k; ii++) {
												if (map[ii][j] == 1) {
													isone = true;
													break;
												}
											}
											if (!isone)
												list.add(new Node(M * i + j + 1, M * k + l + 1, k - i - 1));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			Node curNode = list.get(i);
			int start = curNode.start;
			int end = curNode.end;
			if (!isSame(start, end) && curNode.cost >= 2) {
				union(start, end);
				cnt++;
				sum += curNode.cost;
			}
		}
		Set<Integer> mySet = new HashSet<>();
		for (int i = 1; i <= N * M; i++)
			mySet.add(find(i));
		if (mySet.size() == 2)
			System.out.println(sum);
		else
			System.out.println(-1);

	}

	static void search(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (wall(nr, nc) && map[nr][nc] == 1) {
				union(M * r + c + 1, M * nr + nc + 1);
			}
		}
	}

	static boolean wall(int nr, int nc) {
		if (nr < 0 || nr >= N || nc < 0 || nc >= M)
			return false;
		return true;
	}

	static void union(int a, int b) {
		arr[find(b)] = find(a);
	}

	static int find(int a) {
		if (arr[a] == a)
			return a;
		return arr[a] = find(arr[a]);
	}

	static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}

}

class Node {
	int start;
	int end;
	int cost;

	public Node(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

}