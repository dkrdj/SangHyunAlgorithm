import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Person {
    int paper;
    int interview;

    public Person(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparingInt(o -> Math.min(o.paper, o.interview)));
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                pq.add(new Person(paper, interview));
            }
            int paper = 100001;
            int interview = 100001;
            int cnt = 0;
            while (!pq.isEmpty()) {
                Person p = pq.poll();
                if (p.paper > paper || p.interview > interview) {
                    continue;
                }
                if (p.paper == p.interview) {
                    paper = p.paper;
                    interview = p.interview;
                } else if (p.paper > p.interview) {
                    paper = p.paper;
                } else {
                    interview = p.interview;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
