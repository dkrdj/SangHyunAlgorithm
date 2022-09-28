import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] cArr = Integer.toString(n).toCharArray();
        for(char c : cArr){
            answer += (c -'0');
        }

        return answer;
    }
}