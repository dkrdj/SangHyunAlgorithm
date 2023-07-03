import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();

        maxPQ.offer(Integer.parseInt(br.readLine()));
        sb.append(maxPQ.peek()).append("\n");

        for (int i = 1; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            if (maxPQ.peek() > next) {
                maxPQ.offer(next);
            } else {
                minPQ.offer(next);
            }
            if (maxPQ.size() > minPQ.size()) {
                minPQ.offer(maxPQ.poll());
            }
            if (minPQ.size() > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }
            sb.append(maxPQ.peek()).append("\n");
        }
        System.out.println(sb);
    }

}
