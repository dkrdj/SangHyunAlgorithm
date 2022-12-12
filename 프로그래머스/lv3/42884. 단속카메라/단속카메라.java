import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1,o2)->o1[1]-o2[1]);//출발
        
        boolean[] visited = new boolean[routes.length];
        for(int i = 0 ; i < routes.length ; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            answer++;
            for(int j = i+1 ; j < routes.length ; j++){
                if(routes[j][0] > routes[i][1]){
                    break;
                } else{
                    visited[j] = true;
                }
            }
        }
        
        
        
        
        
        return answer;
    }
}