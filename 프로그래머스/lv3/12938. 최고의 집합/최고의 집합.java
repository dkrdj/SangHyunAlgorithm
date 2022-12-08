import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(s / n == 0)
            return new int[]{-1};
        int diff = s - ((s / n) * n);
        int[] ans = new int[n];
        Arrays.fill(ans, s/n);
        for(int i = 0 ; i < diff ; i++){
            ans[ans.length - 1 - i]++;
        }
        return ans;
    }
}