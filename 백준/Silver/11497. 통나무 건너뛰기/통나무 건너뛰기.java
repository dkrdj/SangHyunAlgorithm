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
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.sort((o1, o2) -> o2 - o1);
            int max = 0;
            for (int i = 0; i + 2 < list.size(); i += 2) {
                max = Math.max(max, list.get(i) - list.get(i + 2));
            }
            for (int i = 1; i + 2 < list.size(); i += 2) {
                max = Math.max(max, list.get(i) - list.get(i + 2));
            }
            System.out.println(max);

        }
    }
}
