import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());
        if (2 * w <= s) {
            System.out.println((x + y) * w);
            return;
        }
        if (s < w) {
            System.out.println(Math.min(x, y) * s + (x - Math.min(x, y)) / 2 * 2 * s + (y - Math.min(x, y)) / 2 * 2 * s + (x - Math.min(x, y)) % 2 * w + (y - Math.min(x, y)) % 2 * w);
            return;
        }
        System.out.println(Math.abs(x - y) * w + Math.min(x, y) * s);
    }
}