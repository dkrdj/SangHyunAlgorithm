import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        Arrays.sort(jobs, (o1,o2)->o1[0]-o2[0]);
        boolean[] isWork = new boolean[1002000];
        for(int i = 0, j = 0; i <= 1000000; i++){
            while(j < jobs.length && jobs[j][0] <= i){
                pq.offer(jobs[j]);
                answer+= jobs[j][1];
                j++;
            }
            // if(!pq.isEmpty()){
            // System.out.println(i);
            // System.out.println(pq);
            // System.out.println("----");
            // }
            if(!isWork[i] && !pq.isEmpty()){
                int[] cur = pq.poll();
                for(int k = i; k < i + cur[1]; k++)
                    isWork[k] = true;
            }
            answer += pq.size();
        }
        
        return answer/jobs.length;
    }
}