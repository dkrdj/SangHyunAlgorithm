import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            boolean isVowel = false;
            char beforeChar = ']';
            int vCount = 0;
            int cCount = 0;

            boolean isValid = true;

            for (char c : str.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cCount = 0;
                    isVowel = true;
                    vCount++;
                    if (vCount == 3) {
                        isValid = false;
                        break;
                    }
                    if (c != 'e' && c != 'o' && beforeChar == c) {
                        isValid = false;
                        break;
                    }
                    beforeChar = c;
                } else {
                    vCount = 0;
                    cCount++;
                    if (cCount == 3) {
                        isValid = false;
                        break;
                    }
                    if (beforeChar == c) {
                        isValid = false;
                        break;
                    }
                    beforeChar = c;
                }
            }
            if (!isVowel) {
                isValid = false;
            }

            sb.append('<').append(str).append("> is ");
            if (!isValid) {
                sb.append("not ");
            }
            sb.append("acceptable.\n");
        }
        System.out.println(sb);
    }
}