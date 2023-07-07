import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= k)
                set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        int[] dp = new int[k + 1];
        list.sort((Comparator.comparingInt(o -> o)));
        for (int num : list) {
            dp[num] = 1;
        }
        for (int i = 1; i <= k; i++) {
            for (int num : list) {
                if (i - num > 0 && dp[i - num] > 0) {
                    if (dp[i] == 0) {
                        dp[i] = dp[i - num] + 1;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        System.out.println(dp[k] == 0 ? -1 : dp[k]);
    }

}