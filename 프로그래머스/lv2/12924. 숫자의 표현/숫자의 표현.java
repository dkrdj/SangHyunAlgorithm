class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; (i+1)*i <= n* 2 ; i++){
            if(i % 2 == 1 && n % i == 0)
                answer++;
            if(i % 2 == 0 && n % i != 0 && n % (i/2) == 0)
                answer++;
        }
        return answer;
    }
}