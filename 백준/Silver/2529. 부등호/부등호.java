import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] bigVisited, smallVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        bigVisited = new boolean[10];
        smallVisited = new boolean[10];
        int bigCount = 0;
        int smallCount = 0;
        StringBuilder bigSB = new StringBuilder();
        StringBuilder smallSB = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String str = st.nextToken();
            bigCount++;
            smallCount++;
            StringBuilder tmp = new StringBuilder();
            if (str.equals(">")) {
                for (int j = 0; j < bigCount; j++) {
                    tmp.append(getBigNumber());
                }
                bigCount = 0;
                bigSB.append(tmp.reverse());
            } else {
                for (int j = 0; j < smallCount; j++) {
                    tmp.append(getSmallNumber());
                }
                smallCount = 0;
                smallSB.append(tmp.reverse());
            }
        }
        bigCount++;
        smallCount++;
        StringBuilder bigTmp = new StringBuilder();
        for (int j = 0; j < bigCount; j++) {
            bigTmp.append(getBigNumber());
        }
        StringBuilder smallTmp = new StringBuilder();
        for (int j = 0; j < smallCount; j++) {
            smallTmp.append(getSmallNumber());
        }
        bigSB.append(bigTmp.reverse());
        smallSB.append(smallTmp.reverse());
        System.out.println(bigSB);
        System.out.println(smallSB);
    }

    private static int getBigNumber() {
        for (int i = 9; i >= 0; i--) {
            if (!bigVisited[i]) {
                bigVisited[i] = true;
                return i;
            }
        }
        return -1;
    }

    private static int getSmallNumber() {
        for (int i = 0; i < 10; i++) {
            if (!smallVisited[i]) {
                smallVisited[i] = true;
                return i;
            }
        }
        return -1;
    }
}