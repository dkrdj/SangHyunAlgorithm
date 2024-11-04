import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] quack = new int[4];
        int max = 0;
        int duck = 0;
        for (char ch : chars) {
            switch (ch) {
                case 'q':
                    quack[0]++;
                    duck++;
                    break;
                case 'u':
                    if (quack[0] <= 0) {
                        System.out.println(-1);
                        return;
                    }
                    quack[0]--;
                    quack[1]++;
                    break;
                case 'a':
                    if (quack[1] <= 0) {
                        System.out.println(-1);
                        return;
                    }
                    quack[1]--;
                    quack[2]++;
                    break;
                case 'c':
                    if (quack[2] <= 0) {
                        System.out.println(-1);
                        return;
                    }
                    quack[2]--;
                    quack[3]++;
                    break;
                case 'k':
                    if (quack[3] <= 0) {
                        System.out.println(-1);
                        return;
                    }
                    quack[3]--;
                    max = Math.max(max, duck);
                    duck--;
                    break;
            }
        }
        if (quack[0] != 0 || quack[1] != 0 || quack[2] != 0 || quack[3] != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);
    }
}
