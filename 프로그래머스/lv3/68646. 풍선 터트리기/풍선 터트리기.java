class Solution {
    public int solution(int[] a) {
        int min = 1000000001;
        int idx = -1;
        for(int i = 0 ; i < a.length ; i++){
            if(min>a[i]){
                min = a[i];
                idx = i;
            }
        }
        int answer = 1;
        int tmp = 1000000001;
        for(int i = 0 ; i < idx ; i++){
            if(tmp>a[i]){
                answer++;
                tmp = a[i];
            }
        }
        tmp = 1000000001;
        for(int i = a.length-1 ; i>idx ; i--){
            if(tmp>a[i]){
                answer++;
                tmp = a[i];
            }
        }
        return answer;
    }
}