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
		long[] arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		SegmentTree segTree = new SegmentTree(N);
		segTree.init(arr, 1, 1, N);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				segTree.update(1, 1, N, b, c);
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(segTree.sum(1, 1, N, b, c)).append("\n");
			}
		}
		System.out.println(sb);
	}

}

class SegmentTree {

	long[] tree;

	SegmentTree(int n) {
		double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
		long treeNodeCount = Math.round(Math.pow(2, treeHeight));
		tree = new long[Math.toIntExact(treeNodeCount)];
	}

	long init(long[] arr, int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		} else {
			return tree[node] = init(arr, node * 2, start, (start + end) / 2)
					+ init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
		}
	}

	long sum(int node, int start, int end, int left, int right) {
		if (end < left || right < start) {
			return 0;
		} else if (left <= start && end <= right) {
			return tree[node];
		} else {
			return sum(node * 2, start, (start + end) / 2, left, right)
					+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		}
	}

	long update(int node, int start, int end, int index, long change) {
		if (index < start || end < index) {
			return tree[node];
		} else if (start == index && end == index) {
			return tree[node] = change;
		} else {
			return tree[node] = update(node * 2, start, (start + end) / 2, index, change)
					+ update(node * 2 + 1, (start + end) / 2 + 1, end, index, change);
		}
	}
}