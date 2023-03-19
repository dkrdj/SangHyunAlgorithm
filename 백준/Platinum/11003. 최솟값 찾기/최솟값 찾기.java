import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.peekLast()[1] > num){
                deque.pollLast();
            }
            deque.addLast(new int[]{i, num});
            if(deque.peekFirst()[0] <i - L + 1){
                deque.pollFirst();
            }
            sb.append(deque.peekFirst()[1]).append(" ");
        }
        System.out.println(sb);
    }


}
