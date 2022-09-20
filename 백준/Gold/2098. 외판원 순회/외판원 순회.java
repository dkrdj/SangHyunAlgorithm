import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr, dp;
    static int[] lastCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        lastCost = new int[N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dp(0, 1));

    }

    private static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for (int i = 0; i < N; i++) {
            if (arr[start][i] != 0)
                dist[i] = arr[start][i];
        }
        PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        visited[start] = true;
        que.add(new Node(start, 0));
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            visited[curNode.end] = true;
            if (curNode.end == end)
                return curNode.cost;
            if (curNode.cost > dist[curNode.end])
                continue;
            for (int i = 0; i < N; i++) {
                if (!visited[i] && arr[curNode.end][i] != 0) {
                    if (dist[i] > dist[curNode.end] + arr[curNode.end][i]) {
                        dist[i] = dist[curNode.end] + arr[curNode.end][i];
                        que.offer(new Node(i, dist[i]));
                    }
                }
            }
        }
        return dist[end];
    }

    private static int dp(int idx, int visited) {
        if (visited == (1 << N) - 1) {
//            System.out.println(arr[idx][0]);
            if(arr[idx][0] == 0) return 100000000;
            return arr[idx][0];
        }
        if (dp[idx][visited] != 0)
            return dp[idx][visited];
        int min = 100000000;
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0 && arr[idx][i] != 0) {
                int nextCost = arr[idx][i] + dp(i, visited | (1 << i));
//                if (idx == N - 2) {
//                    nextCost += dijkstra(i, 0);
//                    System.out.println(i);
//                    System.out.println(dijkstra(i, 0));
//                }
                min = Math.min(min, nextCost);
            }
        }
        dp[idx][visited] = min;
        return dp[idx][visited];
    }
}

class Node {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.cost = cost;
        this.end = end;
    }
}