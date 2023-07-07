import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        max[0] = min[0] = Integer.parseInt(st.nextToken());
        max[1] = min[1] = Integer.parseInt(st.nextToken());
        max[2] = min[2] = Integer.parseInt(st.nextToken());
        int preMax0, preMax1, preMax2, preMin0, preMin1, preMin2, arr0, arr1, arr2;
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr0 = Integer.parseInt(st.nextToken());
            arr1 = Integer.parseInt(st.nextToken());
            arr2 = Integer.parseInt(st.nextToken());
            preMax0 = max[0];
            preMax1 = max[1];
            preMax2 = max[2];
            preMin0 = min[0];
            preMin1 = min[1];
            preMin2 = min[2];
            max[0] = Math.max(preMax0, preMax1) + arr0;
            max[1] = Math.max(preMax0, Math.max(preMax1, preMax2)) + arr1;
            max[2] = Math.max(preMax1, preMax2) + arr2;
            min[0] = Math.min(preMin0, preMin1) + arr0;
            min[1] = Math.min(preMin0, Math.min(preMin1, preMin2)) + arr1;
            min[2] = Math.min(preMin1, preMin2) + arr2;
        }
        System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
    }
}