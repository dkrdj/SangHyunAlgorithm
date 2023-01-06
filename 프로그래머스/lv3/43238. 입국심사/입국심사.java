class Solution {
    public long solution(int n, int[] times) {
        long answer = binarySearch(0, 1000000000000000000L, n, times);
        return answer;
    }
    
    public long binarySearch(long left, long right, int n, int[] times){
        long middle = (left + right) / 2;
        if(left == right){
            return left;
        }
        else if(func(middle, times, n)){
            return binarySearch(middle + 1, right, n, times);
        }
        else{
            return binarySearch(left, middle, n, times);
        }
    }
    
    public boolean func(long num, int[] times, int n){
        long res = 0;
        for(int t : times){
            res += num / t;
        }
        return n > res;
    }
}