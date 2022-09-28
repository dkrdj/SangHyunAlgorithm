class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long init = x;
        for(int i = 0 ; i < n ; i++){
            answer[i] = init;
            init += x;
        }
        return answer;
    }
}