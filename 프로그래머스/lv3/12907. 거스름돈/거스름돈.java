class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[n+1][money.length+1];
        for(int i = 0 ; i <= money.length ; i++){
            dp[0][i] = 1;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j =1; j<=money.length ; j++){
                dp[i][j] = dp[i][j-1];
                if(i-money[j-1]>=0){
                    dp[i][j]+=dp[i-money[j-1]][j];
                }
                // System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
            }
        }
        return dp[n][money.length];
    }
}