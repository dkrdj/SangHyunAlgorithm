import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            Queue<Print> que = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                Print print = new Print(priority);
                if (j == M) {
                    print.selected = true;
                }
                que.offer(print);
                arr[priority]++;
            }
            int cnt = 0;
            int priority = 9;
            while (priority != 0) {
                if (arr[priority] == 0) {
                    priority--;
                    continue;
                }
                Print print = que.poll();
                if (print.priority == priority) {
                    arr[priority]--;
                    cnt++;
                    if (print.selected)
                        break;
                    continue;
                }
                que.offer(print);
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);


    }

}

class Print {
    boolean selected;
    int priority;

    public Print(int priority) {
        this.priority = priority;
    }
}


