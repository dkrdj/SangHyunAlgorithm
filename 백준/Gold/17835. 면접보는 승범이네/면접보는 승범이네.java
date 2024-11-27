import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int n, m, k;
    static List<Node>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[end].add(new Node(start, dist));
        }
        long[] answer = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            answer[i] = Long.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Node(end, 0));
            answer[end] = 0;
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.num]) {
                continue;
            }
            visited[node.num] = true;
            if (node.dist > answer[node.num]) {
                continue;
            }
            for (Node cur : list[node.num]) {
                if (answer[cur.num] > cur.dist + node.dist) {
                    answer[cur.num] = cur.dist + node.dist;
                    pq.offer(new Node(cur.num, answer[cur.num]));
                }
            }
        }
        int idx = 0;
        long max = 0;
        for (int i = 1; i <= n; i++) {
            if (answer[i] > max) {
                idx = i;
                max = answer[i];
            }
        }
        System.out.println(idx);
        System.out.println(max);
    }
}

class Node {
    int num;
    long dist;

    public Node(int num, long dist) {
        this.num = num;
        this.dist = dist;
    }
}
