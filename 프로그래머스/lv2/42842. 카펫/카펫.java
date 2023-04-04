class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow; // ab
        int sumLength = brown/2+2; //a+b
        for(int i = 1 ; i <= sumLength/2;i++){
            if(i * (sumLength-i) == area){
                return new int[]{sumLength-i, i};
            }
        }
        return null;
    }
}