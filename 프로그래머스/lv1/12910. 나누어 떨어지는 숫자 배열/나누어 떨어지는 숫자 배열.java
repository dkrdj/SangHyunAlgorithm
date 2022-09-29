import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] result = new int[arr.length];
        int cnt = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                result[cnt++] = arr[i];
            }
        }
        int[] answer = new int[cnt];
        if(cnt != 0){
            for(int i = 0 ; i < cnt; i++){
                answer[i] = result[i];
            }
        } else{
            answer = new int[]{-1};
        }
        Arrays.sort(answer);
        return answer;
    }
}