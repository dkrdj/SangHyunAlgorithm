import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        int M;
        switch (c) {
            case 'Y':
                M = 2;
                break;
            case 'F':
                M = 3;
                break;
            case 'O':
                M = 4;
                break;
            default:
                M = 0;
                break;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        System.out.println(set.size() / (M - 1));

    }
}