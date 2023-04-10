import java.util.*;

public class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int result = 0;
        for(int i = 0 ; i <binary.length() ; i++){
            if(binary.charAt(i) == '1')
                result++;
        }
        return result;
    }
}