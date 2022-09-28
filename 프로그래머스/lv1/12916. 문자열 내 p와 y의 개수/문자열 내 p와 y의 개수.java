class Solution {
    boolean solution(String s) {
        String str = s.toUpperCase();
        char[] cArr = str.toCharArray();
        int cntP = 0;
        int cntY = 0;
        for(char c  : cArr){
            if(c == 'P') cntP++;
            else if(c == 'Y') cntY++;
        }
        if(cntP == cntY) return true;
        else return false;
    }
}