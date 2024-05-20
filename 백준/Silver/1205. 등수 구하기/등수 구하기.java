import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int min = 2000000001;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        if (N != 0)
            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            min = Math.min(min, score);
            pq.offer(score);
        }
        if (N == P && min >= T) {
            System.out.println(-1);
            return;
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            answer++;
            if (T >= pq.poll()) {
                System.out.println(answer);
                return;
            }
        }
        System.out.println(N + 1);
    }
}