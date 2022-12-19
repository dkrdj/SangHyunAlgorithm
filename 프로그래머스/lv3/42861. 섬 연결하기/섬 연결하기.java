import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int[] arr = new int[n];
        for(int i = 0 ; i < n ;i++){
            arr[i] = i;
        }
        int answer = 0;
        Arrays.sort(costs, (o1,o2)->o1[2] - o2[2]);
        int cnt = 0;
        int idx = 0;
        while(cnt != n-1){
            int[] cur = costs[idx];
            if(isUnion(arr, cur[0],cur[1])){
                idx++;
                continue;
            }
            answer+=cur[2];
            union(arr, cur[0], cur[1]);
            cnt++;
            idx++;
        }
        return answer;
    }
    
    public void union(int[] arr, int a, int b){
        arr[find(arr, b)] = arr[find(arr, a)];
    }
    
    public boolean isUnion(int[] arr, int a, int b){
        return find(arr, a) == find(arr, b);
    }
    
    public int find(int[] arr, int a){
        if(arr[a] == a)
            return a;
        else
            return arr[a] = find(arr, arr[a]);
    }
}