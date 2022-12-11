class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = dp(n ,m, puddles);
        
        return answer;
    }
    
    public int dp(int m, int n , int[][] puddles){
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1;
        
        for(int i = 1 ; i <= n ;i++){
            for(int j = 1 ; j<= m ; j++){
                if(i==1 && j==1)
                    continue;
                
                boolean flag = false;
                
                for(int k = 0 ; k < puddles.length ; k++)
                    if(puddles[k][0] == i && puddles[k][1] == j)
                        flag = true;
                
                if(!flag)
                    map[i][j] = (map[i-1][j]+map[i][j-1])%1000000007;
            }
        }
        return map[n][m];
    }
}