import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> h = new LinkedList<>();
        Queue<Integer> p = new LinkedList<>();
        int idx = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == 'H') h.offer(idx);
            else p.offer(idx);
            idx++;
        }
        int cnt = 0;
        while (!h.isEmpty() && !p.isEmpty()) {
            int ham = h.peek();
            int person = p.peek();
            if (ham > person + K) {
                p.poll();
            } else if (person - K > ham) {
                h.poll();
            } else {
                h.poll();
                p.poll();
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}