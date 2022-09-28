class Solution {
    public long solution(long n) {
        long tmp = (long)Math.sqrt(n);
        if(tmp*tmp == n) return (tmp+1)*(tmp+1);
        else return -1;
    }
}