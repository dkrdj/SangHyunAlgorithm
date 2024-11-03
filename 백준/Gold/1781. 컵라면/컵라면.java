import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Problem {
    int deadline;
    int reward;

    public Problem(int deadline, int reward) {
        this.deadline = deadline;
        this.reward = reward;
    }
}


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Problem> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            list.add(new Problem(deadline, reward));
        }
        list.sort((o1, o2) -> o1.deadline == o2.deadline ? o2.reward - o1.reward : o1.deadline - o2.deadline);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Problem problem : list) {
            if (problem.deadline > pq.size()) {
                pq.offer(problem.reward);
            } else {
                if (problem.reward > pq.peek()) {
                    pq.poll();
                    pq.offer(problem.reward);
                }
            }
        }
        int answer = 0;
        for (int i : pq) {
            answer += i;
        }
        System.out.println(answer);
    }
}
