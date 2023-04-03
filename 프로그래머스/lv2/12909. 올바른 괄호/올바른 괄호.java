class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(cnt < 0) return false;
            if(c == '(') cnt++;
            else cnt--;
        }
        if(cnt == 0)
            return true;
        return false;
    }
}