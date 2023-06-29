import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] check = new int[n + 1];
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if (arr[i] == i) {
                    check[i] = 1;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    Set<Integer> set = new HashSet<>();
                    check[i] = 2;
                    int target = i;
                    boolean flag = false;
                    while (check[arr[target]] == 0) {
                        int size = set.size();
                        set.add(target);
                        if (size == set.size()) {
                            flag = true;
                            break;
                        }
                        target = arr[target];
                    }
                    if (flag) {
                        for (int idx : set) {
                            check[idx] = 0;
                        }
                        check[i] = -1;
                        continue;
                    }
                    set.add(target);
                    if (check[arr[target]] == 2) {
                        for (int idx : set) {
                            check[idx] = 1;
                        }
                    } else {
                        for (int idx : set) {
                            check[idx] = -1;
                        }
                    }
                }
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (check[i] == -1)
                    count++;
            }
            System.out.println(count);
        }
    }
}