import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node> chicken;
    static List<Node> house;
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    house.add(new Node(i, j, 0));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Node(i, j, 0));
                }
            }
        }
        comb(0, 0, 0);
        System.out.println(min);

    }

    static void comb(int idx, int sidx, int visited) {
        if (idx == chicken.size() - M) {
            min = Math.min(min, count(visited));
            return;
        }
        for (int i = sidx; i < chicken.size(); i++) {
            if ((visited & (1 << i)) == 0) {
                comb(idx + 1, i + 1, visited | (1 << i));
            }
        }
    }

    static int count(int visited) {
        int ans = 0;
        int[] dc = {1, -1, 0, 0}, dr = {0, 0, 1, -1};
        for (int i = 0; i < house.size(); i++) {
            Node hn = house.get(i);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++) {
                if ((visited & (1 << j)) == 0) {
                    Node cn = chicken.get(j);
                    int dist = Math.abs(cn.r - hn.r) + Math.abs(cn.c - hn.c);
                    min = Math.min(min, dist);
                }
            }
            ans += min;
        }
        return ans;
    }

}

class Node {
    int r;
    int c;
    int cost;

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}