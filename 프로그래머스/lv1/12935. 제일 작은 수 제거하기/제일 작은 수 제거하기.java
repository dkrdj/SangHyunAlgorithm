class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        int[] answer = new int[arr.length-1];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            min = Math.min(min, arr[i]);
        }
        for(int i = 0, cnt = 0; i < arr.length ; i++){
            if(arr[i] != min)
                answer[cnt++] = arr[i];
        }
        return answer;
    }
}