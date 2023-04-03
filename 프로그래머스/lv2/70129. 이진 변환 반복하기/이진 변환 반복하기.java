class Solution {
    int convertCount = 0;
    int deleteCount = 0;
    public int[] solution(String s) {
        convert(s);
        int[] answer = new int[]{convertCount, deleteCount};
        return answer;
    }
    public void convert(String s){
        convertCount++;
        int oneCount = 0;
        for(char idx : s.toCharArray()){
            if(idx == '0'){
                deleteCount++;
                continue;
            }
            oneCount++;
        }
        if(oneCount == 1)
            return;
        convert(Integer.toBinaryString(oneCount));
    }
}