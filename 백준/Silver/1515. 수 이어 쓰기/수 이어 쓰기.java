import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Queue<Character> queue = new LinkedList<>();
        int idx = 0;
        for (int i = 1; ; i++) {
            for (char c : Integer.toString(i).toCharArray()) {
                queue.offer(c);
            }
            while (!queue.isEmpty()) {
                char c = queue.poll();
                if (arr[idx] == c) {
                    idx++;
                    if (idx == arr.length) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }
}