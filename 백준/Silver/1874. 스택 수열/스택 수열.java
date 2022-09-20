import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        boolean result = true;
        int num = 1;
        for(int i = 0 ; i < N ; i++){
            if(num <= A[i]){
                while(num <= A[i]){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int n = stack.pop();
                if(n == A[i]){
                    sb.append("-\n");
                }
                else{
                    System.out.println("NO");
                    result = false;
                    i = N;
                }
            }
        }
        if (result){
            System.out.println(sb);
        }
    }
}
