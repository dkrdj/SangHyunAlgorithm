import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] prime = new boolean[2000001];
        List<Integer> primes = new ArrayList<>();
        for(int i = 2 ; i*i < 2000001 ; i++){
            if(!prime[i]) {
                primes.add(i);
                for (int j = i; j < 2000001; j += i) {
                    prime[j] = true;
                }
            }
        }
        for(int i = 2 ; i < 2000001 ; i++){
            if(!prime[i])
                primes.add(i);
        }
        outer: for(int t = 0 ; t < T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long sum = A + B;
            if(sum < 4) {
                sb.append("NO\n");
                continue;
            }
            if(sum % 2 != 0){
                sum -= 2;
                for(int i = 0 ; i < primes.size() && sum > primes.get(i) ; i++){
                    if(sum % primes.get(i) == 0){
                        sb.append("NO\n");
                        continue outer;
                    }
                }
            }
            sb.append("YES\n");
        }
        System.out.print(sb);
    }
}
