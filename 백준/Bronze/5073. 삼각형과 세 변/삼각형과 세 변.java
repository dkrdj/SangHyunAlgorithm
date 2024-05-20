import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0)
                break;
            if (a == b && b == c) {
                System.out.println("Equilateral");
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            list.sort(Comparator.comparingInt(o -> o));
            if (list.get(0) + list.get(1) <= list.get(2)) {
                System.out.println("Invalid");
                continue;
            }
            if (a == b || b == c || a == c) {
                System.out.println("Isosceles");
                continue;
            }
            System.out.println("Scalene");
        }
    }
}