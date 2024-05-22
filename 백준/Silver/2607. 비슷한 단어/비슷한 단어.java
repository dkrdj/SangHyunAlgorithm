import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        Map<String, Boolean> map = new HashMap<>();
        char[] chars = first.toCharArray();
        Arrays.sort(chars);
        map.put(String.valueOf(chars), true);
        for (char c = 'A'; c <= 'Z'; c++) {
            String tmp = first + c;
            chars = tmp.toCharArray();
            Arrays.sort(chars);
            map.put(String.valueOf(chars), true);
        }
        for (int i = 0; i < first.length(); i++) {
            String tmp = first.substring(0, i) + first.substring(i + 1);
            chars = tmp.toCharArray();
            Arrays.sort(chars);
            map.put(String.valueOf(chars), true);
            for (char c = 'A'; c <= 'Z'; c++) {
                chars = (tmp + c).toCharArray();
                Arrays.sort(chars);
                map.put(String.valueOf(chars), true);
            }
        }
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            chars = br.readLine().toCharArray();
            Arrays.sort(chars);
            if (map.get(String.valueOf(chars)) != null) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}