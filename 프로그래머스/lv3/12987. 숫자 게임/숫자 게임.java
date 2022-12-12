import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0, j = 0 ; i < A.length && j < B.length; i++, j++){
            if(B[j]> A[i]) answer++;
            else i--;
        }
        return answer;
    }
}