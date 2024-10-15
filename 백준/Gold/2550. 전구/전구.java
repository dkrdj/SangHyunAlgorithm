import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            a[num] = i;
        }
        st = new StringTokenizer(br.readLine());
        int[] answer = new int[N];
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> bStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int s = Integer.parseInt(st.nextToken());
            bStack.push(s);
            int cur = a[s];
            int curIdx = -1;
            for (int j = idx - 1; j >= 0; j--) {
                if (a[answer[j]] < cur) {
                    curIdx = j + 1;
                    break;
                }
            }
            if (curIdx == -1)
                curIdx = 0;
            stack.push(curIdx);
            answer[curIdx] = s;
            idx = Math.max(idx, curIdx + 1);
        }
        idx--;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int s = stack.pop();
            int b = bStack.pop();
            if (s == idx) {
                list.add(b);
                idx--;
            }
        }
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        list.sort(Comparator.comparingInt(o -> o));
        for (int l : list) {
            sb.append(l).append(" ");
        }
        System.out.println(sb);
    }
}