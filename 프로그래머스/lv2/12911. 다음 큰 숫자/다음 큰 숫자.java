class Solution {
    public int solution(int n) {
        int cnt = count(n);
        while(count(++n) != cnt){
        }
        return n;
    }
    public int count(int n){
        int cnt = 0;
        while(n != 1){
            if(n % 2 == 1)
                cnt++;
            n /= 2;
        }
        return cnt + 1;
    }
}