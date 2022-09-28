class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] cArr = s.toCharArray();
        if(cArr[0] == '+' || cArr[0] == '-'){
            for(int i = cArr.length - 1, cnt = 0 ; i >0 ; i--, cnt++){
                answer += (cArr[i] - '0') * Math.pow(10, cnt);
            }
            if(cArr[0] == '-') answer *= -1;
        } else{
            for(int i = cArr.length - 1, cnt = 0 ; i >=0 ; i--, cnt++){
                answer += (cArr[i] - '0') * Math.pow(10, cnt);
            }
        }
        return answer;
    }
}