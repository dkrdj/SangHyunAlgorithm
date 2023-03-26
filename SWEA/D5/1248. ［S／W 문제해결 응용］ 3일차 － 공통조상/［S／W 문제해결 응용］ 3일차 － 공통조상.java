import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            Node[] nodes = new Node[v + 1];
            for (int i = 1; i <= v; i++) {
                nodes[i] = new Node(i);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                nodes[parent].child.add(nodes[child]);
                nodes[child].parent = nodes[parent];
            }
            nodes[1].level = 1;
            setLevel(nodes[1]);
            Node node1 = nodes[num1];
            Node node2 = nodes[num2];
            int level = Math.min(node1.level, node2.level);
            while (node1.level != level) {
                node1 = node1.parent;
            }
            while (node2.level != level) {
                node2 = node2.parent;
            }
            while (node1 != node2) {
                node1 = node1.parent;
                node2 = node2.parent;
            }
            sb.append(node1.idx).append(" ").append(count(node1)).append("\n");
        }
        System.out.println(sb);
    }

    private static void setLevel(Node parent) {
        for (Node child : parent.child) {
            child.level = parent.level + 1;
            setLevel(child);
        }
    }

    private static int count(Node node1) {
        int cnt = 1;
        for (Node node : node1.child) {
            cnt += count(node);
        }
        return cnt;
    }
}

class Node {
    int idx;
    int level;
    List<Node> child;
    Node parent;

    public Node(int idx) {
        this.idx = idx;
        child = new ArrayList<>();
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

}