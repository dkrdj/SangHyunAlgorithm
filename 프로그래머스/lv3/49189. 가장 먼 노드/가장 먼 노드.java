import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] edgeList = new ArrayList[n+1];
        for(int i = 1 ; i <= n ;i++){
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < edge.length ; i++){
            edgeList[edge[i][0]].add(edge[i][1]);
            edgeList[edge[i][1]].add(edge[i][0]);
        }
        int[] dist = new int[n+1];
        bfs(n, edgeList, dist);
        int max = 0;
        int answer = 0;
        for(int i = 0 ; i < dist.length ; i++)
            if(dist[i]>max){
                max = dist[i];
                answer = 1;
            } else if(dist[i] == max)
                answer++;
        return answer;
    }
    
    public void bfs(int n, List<Integer>[] edgeList, int[] dist){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> que = new LinkedList<>();
        visited[1] = true;
        que.offer(1);
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int i = 0 ; i < edgeList[cur].size() ; i++){
                int end = edgeList[cur].get(i);
                if(!visited[end]){
                    visited[end] = true;
                    que.offer(end);
                    dist[end] = dist[cur]+1;
                }
            }
        }
    }
}