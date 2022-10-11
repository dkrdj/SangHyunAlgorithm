import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 2) {
            System.out.println(0);
            return;
        }

        List<Integer> primeList = new ArrayList<>();
        boolean[] prime = new boolean[4000001];
        for (int i = 2; i * i <= 4000000; i++) {
            if (!prime[i]) {
                for (int j = 2; i * j <= 4000000; j++) {
                    prime[i * j] = true;
                }
            }
        }
        for (int i = 2; i <= 4000000; i++) {
            if (!prime[i])
                primeList.add(i);
        }

        int start = 0, end = 0;
        int sum = primeList.get(0);
        int cnt = 0;
        while (!(start == end && sum > N)) {
            if (sum > N) {
                sum -= primeList.get(start++);
            } else if (sum < N) {
                if (++end >= primeList.size()) break;
                sum += primeList.get(end);
            } else {
                cnt++;
                if (++end >= primeList.size()) break;
                sum -= primeList.get(start++);
                sum += primeList.get(end);
            }
        }
        System.out.println(cnt);
    }
}