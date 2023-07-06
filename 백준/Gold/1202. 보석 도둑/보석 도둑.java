import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }
        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags);
        Collections.sort(jewels, Comparator.comparingInt(o -> o.m));
        PriorityQueue<Jewel> pq = new PriorityQueue<>(((o1, o2) -> o2.v - o1.v));
        int idx = 0;
        long answer = 0;
        for (int bag : bags) {
            while (idx < jewels.size() && jewels.get(idx).m <= bag) {
                pq.offer(jewels.get(idx));
                idx++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll().v;
            }
        }
        System.out.println(answer);
    }

}

class Jewel {
    int m;
    int v;

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}