import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static String[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long sum = 0L;
        int min = Integer.MAX_VALUE;
        Queue<Long> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(st.nextToken());
            sum += a;
            que.offer(a);
            if (sum >= S) {
                long peek = que.peek();
                while (!que.isEmpty() && sum - peek >= S) {
                    sum -= peek;
                    que.poll();
                    peek = que.peek();
                }
                min = Math.min(min, que.size());
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}