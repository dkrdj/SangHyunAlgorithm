import java.util.*;
class Solution {
    public int[] solution(long n) {
        Stack<Integer> stack = new Stack<>();
        char[] cArr = Long.toString(n).toCharArray();
        int[] answer = new int[cArr.length];
        for(char c: cArr){
            stack.push(c-'0');
        }
        int cnt = 0;
        while(!stack.isEmpty()){
           answer[cnt++] = stack.pop();
        }
        
        return answer;
    }
}