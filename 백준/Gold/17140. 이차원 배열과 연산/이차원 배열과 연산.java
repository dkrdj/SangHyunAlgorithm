import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[101][101];
    static int rSize, cSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rSize = 3;
        cSize = 3;
        int ans = 0;
        while (arr[r][c] != k && ans <= 100) {
            if (rSize >= cSize) {
                sortR(cSize);
            } else {
                sortC(rSize);
            }
            ans++;
        }
        System.out.println(ans == 101 ? -1 : ans);
    }

    static void sortR(int size) {
        cSize = 0;
        for (int k = 1; k <= rSize; k++) {
            int[] sArr = new int[101];

            for (int i = 1; i <= size; i++) {
                sArr[arr[k][i]]++;
            }
            List<Node> list = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                if (sArr[i] > 0) {
                    list.add(new Node(i, sArr[i]));
                }
            }
            list.sort((o1, o2) -> {
                if (o1.cnt == o2.cnt) {
                    return o1.num - o2.num;
                } else {
                    return o1.cnt - o2.cnt;
                }
            });
            int len = list.size();
            for (int i = 0; i < len; i++) {
                Node node = list.get(i);
                arr[k][2 * i + 1] = node.num;
                arr[k][2 * i + 2] = node.cnt;
            }
            cSize = Math.max(cSize, len * 2);
            for (int i = len * 2 + 1; i <= size; i++) {
                arr[k][i] = 0;
            }
        }
    }

    static void sortC(int size) {
        rSize = 0;
        for (int k = 1; k <= cSize; k++) {
            int[] sArr = new int[101];

            for (int i = 1; i <= size; i++) {
                sArr[arr[i][k]]++;
            }
            List<Node> list = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                if (sArr[i] > 0) {
                    list.add(new Node(i, sArr[i]));
                }
            }
            list.sort((o1, o2) -> {
                if (o1.cnt == o2.cnt) {
                    return o1.num - o2.num;
                } else {
                    return o1.cnt - o2.cnt;
                }
            });

            int len = list.size();
            for (int i = 0; i < len; i++) {
                Node node = list.get(i);
                arr[2 * i + 1][k] = node.num;
                arr[2 * i + 2][k] = node.cnt;
            }

            rSize = Math.max(rSize, len * 2);
            for (int i = len * 2 + 1; i <= size; i++) {
                arr[i][k] = 0;
            }
        }
    }
}

class Node {
    int num;
    int cnt;

    public Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}
