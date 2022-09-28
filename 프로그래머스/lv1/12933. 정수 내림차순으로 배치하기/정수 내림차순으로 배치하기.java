import java.util.*;

class Solution {
    public long solution(long n) {
        char[] cArr = Long.toString(n).toCharArray();
        Integer[] arr = new Integer[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            arr[i] = cArr[i] - '0';
        }
        Arrays.sort(arr);
        long res = 0;
        for(int i = 0 ; i < arr.length ; i++){
            res += arr[i] * Math.pow(10,i);
        }
        return res;
    }
}