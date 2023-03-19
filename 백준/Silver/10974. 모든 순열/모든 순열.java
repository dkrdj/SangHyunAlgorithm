import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        perm(N, new boolean[N+1], new int[N], 0);
        System.out.println(sb);
    }
    public static void perm(int N, boolean[] visited, int[] arr, int idx){
        if(idx == N){
            for(int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        for(int i = 1 ; i <= N ; i++){
            if(!visited[i]){
                arr[idx] = i;
                visited[i] = true;
                perm(N, visited, arr, idx+1);
                visited[i] = false;
                arr[idx] = 0;
            }
        }
    }



}
