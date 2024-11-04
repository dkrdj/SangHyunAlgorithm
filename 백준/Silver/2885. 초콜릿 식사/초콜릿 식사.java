import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int choco = (int) Math.pow(2, chars.length - 1);
        int cnt = 0;
        if (n != choco) {
            choco *= 2;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    cnt = i + 1;
                }
            }
        }
        System.out.println(choco + " " + cnt);
    }
}
