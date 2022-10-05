import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        long[] dp = new long[1001];
        dp[1] = 1;
        int pcnt = 0;
        for (int i = 2, cnt = 1; i <= 1000; i++) {
            dp[i] = dp[i - 1] + (long) Math.pow(2, cnt);
            if (pcnt == cnt) {
                pcnt = 0;
                cnt++;
            } else {
                pcnt++;
            }
        }
        int cnt = 1;
        while (str != null && !str.equals("")) {
            int N = Integer.parseInt(str);
            sb.append("Case ").append(cnt++).append(": ").append(dp[N]).append("\n");
            str = br.readLine();
        }
        System.out.println(sb);
    }

}