import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++){
            int n = Integer.parseInt(br.readLine());
            perm(n, new int[n], 0);
            System.out.println(ans);
            ans = 0;
        }
    }
    public static void perm(int n, int[] arr, int idx){
        if(!check(n,arr, idx)){
            return;
        }
        if(idx == n){
            return;
        }
        for(int i = 1 ; i <= 3 ; i++){
                arr[idx] = i;
                perm(n, arr, idx+1);
                arr[idx] = 0;
        }
    }

    private static boolean check(int n, int[] arr, int idx) {
        int sum = 0;
        for(int i = 0 ; i < idx ; i++){
            sum += arr[i];
        }
        if(sum < n)
            return true;
        else if (sum == n){
            ans++;
            return false;
        }
        else{
            return false;
        }
    }


}
