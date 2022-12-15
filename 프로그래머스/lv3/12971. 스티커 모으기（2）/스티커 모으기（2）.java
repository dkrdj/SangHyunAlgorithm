import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1)
            return sticker[0];
        
        int[][] dp = new int[2][sticker.length];
        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        dp[1][1] = sticker[1];
        for(int j = 2; j < sticker.length - 1; j++){
            dp[0][j] = Math.max(dp[0][j-1], dp[0][j-2]+sticker[j]);
        }
        for(int j = 2; j < sticker.length; j++){
            dp[1][j] = Math.max(dp[1][j-1], dp[1][j-2]+sticker[j]);
        }
                
        return Math.max(dp[0][sticker.length-2], dp[1][sticker.length-1]);
    }
}