import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> que = new PriorityQueue<>((o1,o2)->o2-o1);
        
        for(int a : works)
            que.offer(a);
        
        for(int i = 0 ; i < n && !que.isEmpty(); i++){
            int cur = que.poll();
            cur--;
            if(cur != 0)
                que.offer(cur);
        }
        
        long answer = 0;
        
        for(int a : que){
            answer += a*a;
        }
        
        return answer;
    }
}