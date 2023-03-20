import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] split = str.substring(1, str.length() - 1).split(",");
            for (int j = 0; j < n; j++) {
                deque.offer(Integer.parseInt(split[j]));
            }

            boolean direction = true;
            boolean isError = false;
            outer:
            for (char c : p) {
                switch (c) {
                    case 'R':
                        direction = !direction;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            isError = true;
                            break outer;
                        }
                        if (direction) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                }
            }
            if (isError) {
                sb.append("error\n");
                continue;
            }

            sb.append('[');
            if (direction) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(',');
                    }
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                    if (!deque.isEmpty()) {
                        sb.append(',');
                    }
                }
            }
            sb.append("]\n");
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


