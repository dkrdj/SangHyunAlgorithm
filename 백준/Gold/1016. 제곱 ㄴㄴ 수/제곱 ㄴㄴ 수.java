import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isPrime = new boolean[1000001];
        for (int i = 2; i * i < 1000001; i++) {
            if (!isPrime[i])
                for (int j = i * i; j < 1000001; j += i) {
                    isPrime[j] = true;
                }
        }
        List<Long> primes = new ArrayList<>();
        for (int i = 2; i < 1000001; i++) {
            if (!isPrime[i])
                primes.add((long) i);
        }
        long count = max - min + 1;
        boolean[] check = new boolean[(int) count];
        for (long prime : primes) {
            for (long i = min / (prime * prime) * prime * prime; i <= max; i += prime * prime) {
                if (i - min >= 0) {
                    check[(int) (i - min)] = true;
                }
            }
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i]) count--;
        }
        System.out.println(count);
    }
}