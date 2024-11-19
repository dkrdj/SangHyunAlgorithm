import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SegmentTree tree = new SegmentTree(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Node(Integer.parseInt(st.nextToken()), i));
        }
        list.sort((o1, o2) -> o1.num != o2.num ? o1.num - o2.num : o1.idx - o2.idx);
        long answer = 0;
        for (Node node : list) {
            answer += tree.query(1, 1, n, node.idx, n);
            tree.update(1, 1, n, node.idx);
        }
        System.out.println(answer);

    }
}

class Node {
    int num;
    int idx;

    public Node(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}

class SegmentTree {
    int[] tree;

    public SegmentTree(int arrSize) {
        this.tree = new int[arrSize * 4];
    }

    void update(int node, int start, int end, int idx) {
        if (start == idx && end == idx) {
            tree[node] = 1;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(node * 2, start, mid, idx);
        } else {
            update(node * 2 + 1, mid + 1, end, idx);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    int query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
                + query(node * 2 + 1, mid + 1, end, left, right);
    }


}
