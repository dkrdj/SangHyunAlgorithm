class Solution {
    public boolean solution(int x) {
        char[] cArr = Integer.toString(x).toCharArray();
        int sum =0;
        for(char c : cArr)
            sum+=c-'0';
        return x%sum == 0;
    }
}