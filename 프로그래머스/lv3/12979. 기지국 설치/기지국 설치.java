import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        outer: for(int i = 1, j = 0; i <= n;){
            if(j < stations.length && i + w >= stations[j]){
                i = stations[j] + w + 1;
                while(j < stations.length && stations[j] < i){
                    j++;
                    i = stations[j - 1] + w + 1;
                }
            } else{
                answer++;
                i += 2 * w + 1;
            }
        }

        return answer;
    }
}