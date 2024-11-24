import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree, lazy;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new long[n * 4];
        lazy = new long[n * 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            init(1, 1, n, a, i);
        }
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + 1;
            if (a == 1) {
                int c = Integer.parseInt(st.nextToken()) + 1;
                int d = Integer.parseInt(st.nextToken());
                update(1, 1, n, b, c, d);
            } else {
                long answer = query(1, 1, n, b, b);
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init(int node, int start, int end, long num, int idx) {
        if (idx < start || idx > end) {
            return;
        }
        if (start == end) {
            tree[node] = num;
            return;
        }
        int mid = start + (end - start) / 2;
        init(node * 2, start, mid, num, idx);
        init(node * 2 + 1, mid + 1, end, num, idx);
        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    static void update(int node, int start, int end, int left, int right, int num) {
        push(node, start, end);
        if (start > right || end < left) {
            return;
        }
        if (start >= left && end <= right) {
            lazy[node] ^= num;
            push(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, num);
        update(node * 2 + 1, mid + 1, end, left, right, num);
        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    static void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            if ((end - start + 1) % 2 != 0)
                tree[node] ^= lazy[node];
            if (start != end) {
                lazy[node * 2] ^= lazy[node];
                lazy[node * 2 + 1] ^= lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        push(node, start, end);
        if (start > right || end < left) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (start >= left && end <= right) {
            return tree[node];
        }
        return query(node * 2, start, mid, left, right)
                ^ query(node * 2 + 1, mid + 1, end, left, right);
    }
}