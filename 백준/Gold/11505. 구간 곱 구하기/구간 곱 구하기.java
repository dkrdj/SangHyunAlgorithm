import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		SegmentTree segTree = new SegmentTree(N);
		segTree.init(arr, 1, 1, N);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				segTree.update(1, 1, N, b, c);
			} else {
				sb.append(segTree.sum(1, 1, N, b, c)).append("\n");
			}
		}
		System.out.println(sb);
	}
}

class SegmentTree {
	long[] tree;

	SegmentTree(int N) {
		double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
		long nodeCnt = Math.round(Math.pow(2, height));
		tree = new long[Math.toIntExact(nodeCnt)];
		for (int i = 1; i <= tree.length - 1; i++) {
			tree[i] = 1;
		}
	}

	long init(int[] arr, int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start];
		else {
			return tree[node] = (init(arr, node * 2, start, (start + end) / 2)
					* init(arr, node * 2 + 1, (start + end) / 2 + 1, end)) % 1000000007;
		}
	}

	long update(int node, int start, int end, int idx, int change) {
		if (idx > end || idx < start)
			return tree[node];
		else if (idx == start && idx == end) {
			return tree[node] = change;
		} else {
			return tree[node] = (update(node * 2, start, (start + end) / 2, idx, change)
					* update(node * 2 + 1, (start + end) / 2 + 1, end, idx, change)) % 1000000007;
		}
	}

	long sum(int node, int start, int end, int left, int right) {
		if (start > right || end < left)
			return 1;
		else if (left <= start && end <= right) {
			return tree[node];
		} else {
			return (sum(node * 2, start, (start + end) / 2, left, right)
					* sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right)) % 1000000007;
		}
	}
}