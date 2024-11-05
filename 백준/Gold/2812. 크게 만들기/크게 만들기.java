import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            arr[i] = ch[i] - '0';
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            while (m - cnt > 0 && !stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
                cnt++;
            }
            stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (cnt != m) {
            stack.pop();
            cnt++;
        }
        for (Integer integer : stack) {
            sb.append(integer);
        }
        System.out.println(sb);
    }
}
