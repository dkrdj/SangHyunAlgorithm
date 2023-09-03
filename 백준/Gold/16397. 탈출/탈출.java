import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        int[] visited = new int[100000];
        boolean[] visit = new boolean[100000];
        visit[N] = true;
        while (!que.isEmpty()) {
            int num = que.poll();
            if (num == G)
                break;
            int numA = num + 1;
            int numB = buttonB(num);
            if (numA < 100000 && !visit[numA]) {
                visited[numA] = Math.max(0, visited[num]) + 1;
                visit[numA] = true;
                que.offer(numA);
            }
            if (numB < 100000 && !visit[numB]) {
                visited[numB] = Math.max(0, visited[num]) + 1;
                visit[numB] = true;
                que.offer(numB);
            }
        }
        if (!visit[G] || visited[G] > T) {
            System.out.println("ANG");
            return;
        }
        System.out.println(visited[G]);
    }

    private static int buttonB(int num) {
        num *= 2;
        if (num >= 100000) {
            return 999999;
        }
        return num - (int) Math.pow(10, getHighIndex(num));
    }

    private static int getHighIndex(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > '0') {
                return chars.length - 1 - i;
            }
        }
        return -1;
    }
}