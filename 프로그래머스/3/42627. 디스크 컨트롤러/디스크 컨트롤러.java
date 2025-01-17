import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int time = 0;
        int idx = 0;
        int answer = 0;
        int cnt = 0;
        while(cnt != jobs.length){
            while(jobs.length > idx && jobs[idx][0] <= time){
                pq.offer(jobs[idx]);
                idx++;
            }
            if(pq.isEmpty()){
                time = jobs[idx][0];
                continue;
            }
            int[] job = pq.poll();
            
            time += job[1];
            answer += time - job[0];
            cnt++;
        }
        return answer / jobs.length;
    }
}