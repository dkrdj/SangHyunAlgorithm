class Solution {
    public int solution(int num) {
        int answer = 0;
        long res = num;
        while(res != 1 && answer != 500){
            if(res % 2 == 0)
                res /= 2;
            else
                res = res * 3 + 1;
            answer++;
        }
        return answer == 500 ? -1 : answer;
    }
}