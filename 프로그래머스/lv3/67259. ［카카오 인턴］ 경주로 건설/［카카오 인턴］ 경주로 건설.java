import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = dijkstra(board);
        return answer;
    }
    
    public int dijkstra(int[][] board){
        //북동남서
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int[][] dist = new int[board.length][board.length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board.length ; j++){
                dist[i][j] = 10000000;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        //int r, int c, int dir, int cost
        pq.offer(new Node(0, 0, 0, 0));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            System.out.println(curNode.r+" "+curNode.c+" "+curNode.dir+" "+curNode.cost);
            for(int i = 0;  i < 4 ; i++){
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];
                if(nr>=0 && nc>=0 && nr<board.length && nc<board.length && board[nr][nc] == 0){
                    if(dist[nr][nc]>=curNode.cost+getCost(curNode, i+1)-500){
                        dist[nr][nc] = Math.min(dist[nr][nc], curNode.cost+getCost(curNode, i+1));
                        pq.offer(new Node(nr, nc, i+1, curNode.cost+getCost(curNode, i+1)));
                    }
                }
            }
        }
        return dist[board.length-1][board.length-1];
    }
    
    public int getCost(Node node, int dir){
        if(node.dir == 0 || node.dir == dir){
            return 100;
        }
        return 600;
    }
}

class Node{
    int r, c, dir, cost;
    public Node(int r, int c, int dir, int cost){
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cost = cost;
    }
}