import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i = n-1 ;i > 0 ; i--){
            if(arr[i] < min){
                min = arr[i];
                minIdx = i;
            }
        }
        int tmp = m - arr[minIdx];
        if(min > m){
            System.out.println(0);
            return;
        }

        for(int i =0 ;i < n ;i++){
            if(arr[i] < min){
                min = arr[i];
                minIdx = i;
            }
        }
        String answer = "";
        int cnt = tmp / min + 1;
        int idx = n-1;
        while(m > 0 && idx > minIdx){
            int left = m - (cnt-1) * arr[minIdx];
            if(left >= arr[idx]){
                m -= arr[idx];
                answer += idx;
                cnt--;
                continue;
            }
            idx--;
        }
        for(int i = 0 ;i < cnt ; i++){
            answer += minIdx;
        }
        System.out.println(answer);


    }
}
