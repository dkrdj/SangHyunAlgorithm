import java.util.*;

class Solution {
    public int count = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i])
                bfs(computers, visited, i);
        }
        return count;
    }
    public void bfs(int[][] computers, boolean[] visited, int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int i = 0 ; i < computers.length ; i++){
                if(!visited[i] && computers[cur][i] == 1){
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }
        count++;
    }
}