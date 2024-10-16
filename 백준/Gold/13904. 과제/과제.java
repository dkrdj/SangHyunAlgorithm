import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> nodePQ = new PriorityQueue<>((o1, o2) -> o1.seq - o2.seq);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int seq = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            nodePQ.offer(new Node(seq, score));
        }
        PriorityQueue<Node> answer = new PriorityQueue<>((o1, o2) -> o1.score - o2.score);
        while (!nodePQ.isEmpty()) {
            Node node = nodePQ.poll();
            if (answer.size() < node.seq) {
                answer.offer(node);
                continue;
            }
            if (answer.isEmpty()) {
                continue;
            }
            Node bNode = answer.peek();
            if (node.score > bNode.score) {
                answer.poll();
                answer.offer(node);
            }
        }
        int sum = 0;
        for (Node node : answer) {
            sum += node.score;
        }
        System.out.println(sum);
    }
}

class Node {
    int seq;
    int score;

    public Node(int seq, int score) {
        this.seq = seq;
        this.score = score;
    }
}