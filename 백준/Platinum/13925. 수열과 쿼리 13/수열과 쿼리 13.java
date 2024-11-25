import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static long[] tree, lazyP, lazyM, lazyI;
    static int n, m;
    static long MOD = 1000000007;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new long[n * 4];
        lazyP = new long[n * 4];
        lazyM = new long[n * 4];
        lazyI = new long[n * 4];
        for (int i = 1; i < n * 4; i++) {
            lazyM[i] = 1;
        }
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
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 4) {
                long answer = query(1, 1, n, b, c);
                sb.append(answer).append("\n");
            } else {
                long d = Integer.parseInt(st.nextToken());
                update(1, 1, n, b, c, d, a);
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
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }


    static void update(int node, int start, int end, int left, int right, long num, int a) {
        push(node, start, end);
        if (start > right || end < left) {
            return;
        }
        if (start >= left && end <= right) {
            if (a == 1) {
                lazyP[node] += num;
                lazyP[node] %= MOD;
            } else if (a == 2) {
                lazyP[node] *= num;
                lazyM[node] *= num;
                lazyP[node] %= MOD;
                lazyM[node] %= MOD;
            } else {
                lazyI[node] = num;
                lazyP[node] = 0;
                lazyM[node] = 1;
            }
            push(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, num, a);
        update(node * 2 + 1, mid + 1, end, left, right, num, a);
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    static void push(int node, int start, int end) {
        if (lazyI[node] != 0) {
            if (start != end) {
                lazyI[node * 2] = lazyI[node];
                lazyM[node * 2] = 1;
                lazyP[node * 2] = 0;
                lazyI[node * 2 + 1] = lazyI[node];
                lazyM[node * 2 + 1] = 1;
                lazyP[node * 2 + 1] = 0;
            }
            tree[node] = lazyI[node] * (end - start + 1);
            tree[node] %= MOD;
            lazyI[node] = 0;
        }
        if (lazyM[node] != 1) {
            if (start != end) {
                lazyM[node * 2] *= lazyM[node];
                lazyM[node * 2 + 1] *= lazyM[node];
                lazyP[node * 2] *= lazyM[node];
                lazyP[node * 2 + 1] *= lazyM[node];
                lazyM[node * 2] %= MOD;
                lazyM[node * 2 + 1] %= MOD;
                lazyP[node * 2] %= MOD;
                lazyP[node * 2 + 1] %= MOD;
            }
            tree[node] *= lazyM[node];
            tree[node] %= MOD;
            lazyM[node] = 1;
        }
        if (lazyP[node] != 0) {
            if (start != end) {
                lazyP[node * 2] += lazyP[node];
                lazyP[node * 2 + 1] += lazyP[node];
                lazyP[node * 2] %= MOD;
                lazyP[node * 2 + 1] %= MOD;
            }
            tree[node] += lazyP[node] * (end - start + 1);
            tree[node] %= MOD;
            lazyP[node] = 0;
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
        return (query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
    }
}