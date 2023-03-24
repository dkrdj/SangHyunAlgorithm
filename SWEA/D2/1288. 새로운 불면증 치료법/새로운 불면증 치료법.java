import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int visited = 0;
            int cnt = 0;
            while (visited != (1 << 10) - 1) {
                cnt++;
                for (char c : String.valueOf(n * cnt).toCharArray())
                    visited |= (1 << ((c - '0')));
            }
            sb.append("#").append(t).append(" ").append(n * cnt).append("\n");
        }
        System.out.println(sb);
    }

}

