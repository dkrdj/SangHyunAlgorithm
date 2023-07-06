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
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int big = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            String str = br.readLine();
            big = Math.max(big, Integer.parseInt(str));
            list.add(str);
        }
        list.sort(((o1, o2) -> {
            String o1res = o1 + o2;
            String o2res = o2 + o1;
            return o2res.compareTo(o1res);
        }));
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (String str : list) {
            int num = Integer.parseInt(str);
            sb.append(num);
            if (!flag && num == big) {
                for (int i = 0; i < N - K; i++) {
                    sb.append(big);
                }
                flag = true;
            }
        }
        System.out.println(sb);
    }
}