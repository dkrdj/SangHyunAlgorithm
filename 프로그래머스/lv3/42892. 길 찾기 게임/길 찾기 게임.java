import java.util.*;

class Solution {
    int preIdx = 0;
    int postIdx = 0;
    public int[][] solution(int[][] nodeinfo) {
        Node[] node = new Node[nodeinfo.length+1];
        for(int i =0  ; i < nodeinfo.length ; i++){
            node[i+1] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        node[0] = new Node(-1,-1, -1);
        Arrays.sort(node, (o1,o2)->o2.y==o1.y?o1.x-o2.x:o2.y-o1.y);
        Node parent = node[0];
        for(int i = 1 ; i < node.length-1 ; i++){
            Node cur = node[i];
            parent.insert(cur);
        }
        int[][] answer = new int[2][nodeinfo.length];
        pre(answer[0], parent);
        post(answer[1], parent);
        return answer;
    }
    public void pre(int[] answer, Node cur){
        answer[preIdx++] = cur.idx;
        if(cur.left != null)
            pre(answer, cur.left);
        if(cur.right != null)
            pre(answer, cur.right);
    }
    public void post(int[] answer, Node cur){
        if(cur.left != null)
            post(answer, cur.left);
        if(cur.right != null)
            post(answer, cur.right);
        answer[postIdx++] = cur.idx;
    }
}
class Node{
    int x;
    int y;
    int idx;
    int child;
    Node right;
    Node left;
    public Node(int x, int y, int idx){
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
    public void insert(Node node){
        if(child == 0){
            if(node.x > this.x){
                right = node;
            } else{
                left = node;
            }
            child = node.y;
            return;
        }
        if(child == node.y){
            if(node.x > this.x){
                right = node;
            } else{
                left = node;
            }
            return;
        }
        if(left != null && right != null){
            if(node.x > this.x){
                right.insert(node);
            } else{
                left.insert(node);
            }
            return;
        }
        if(left != null){
            left.insert(node);
        } else{
            right.insert(node);
        }
    }
    public String toString(){
        return "x : "+x+", y : "+y+", idx : "+idx+"\n";
    }
}