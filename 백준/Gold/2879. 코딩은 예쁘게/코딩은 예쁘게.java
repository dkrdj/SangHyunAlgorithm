import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Problem {
    int deadline;
    int reward;

    public Problem(int deadline, int reward) {
        this.deadline = deadline;
        this.reward = reward;
    }
}


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] -= Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int idx = 0;
        while(idx < N) {
            if(arr[idx] > 0) {
                int min = arr[idx];
                int end = N;
                for (int i = idx+1; i < N; i++) {
                    if (arr[i] <= 0) {
                        end = i;
                        break;
                    }
                    min = Math.min(min, arr[i]);
                }
                for(int i = idx ; i < end ; i++){
                    arr[i] -= min;
                }
                answer += min;
            } else if(arr[idx] < 0){
                int max = arr[idx];
                int end = N;
                for (int i = idx+1; i < N; i++) {
                    if (arr[i] >= 0) {
                        end = i;
                        break;
                    }
                    max = Math.max(max, arr[i]);
                }
                for(int i = idx ; i < end ; i++){
                    arr[i] -= max;
                }
                answer -= max;
            }else{
                idx++;
            }


        }
        System.out.println(answer);
    }
}
