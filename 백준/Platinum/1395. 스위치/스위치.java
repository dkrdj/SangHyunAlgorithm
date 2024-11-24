import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node[] tree;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new Node[n * 4];
        for (int i = 1; i < 4 * n; i++) {
            tree[i] = new Node(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                update(1, 1, n, b, c);
            } else {
                long answer = query(1, 1, n, b, c);
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void update(int node, int start, int end, int left, int right) {
        push(node, start, end);
        if (start > right || end < left) {
            return;
        }
        if (start >= left && end <= right) {
            tree[node].lazy++;
            push(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right);
        update(node * 2 + 1, mid + 1, end, left, right);
        tree[node].num = tree[node * 2].num + tree[node * 2 + 1].num;
    }

    static void push(int node, int start, int end) {
        if (tree[node].lazy != 0) {
            if (tree[node].lazy % 2 != 0) {
                tree[node].num = (end - start + 1) - tree[node].num;
                if (start != end) {
                    tree[node * 2].lazy += tree[node].lazy;
                    tree[node * 2 + 1].lazy += tree[node].lazy;
                }
            }
            tree[node].lazy = 0;
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        push(node, start, end);
        if (start > right || end < left) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (start >= left && end <= right) {
            return tree[node].num;
        }
        return query(node * 2, start, mid, left, right)
                + query(node * 2 + 1, mid + 1, end, left, right);
    }
}

class Node {
    long lazy;
    long num;

    public Node(long num) {
        this.num = num;
        this.lazy = 0L;
    }
}