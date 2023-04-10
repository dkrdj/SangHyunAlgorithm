class Solution {
    public int solution(int[] people, int limit) {
        int[] arr = new int[limit+1];
        for(int person : people){
            arr[person]++;
        }
        for(int i = 40 ; i + 1 <= limit ; i++){
            arr[i+1] += arr[i];
        }
        int[] sort = new int[people.length];
        for(int i = people.length-1 ; i>=0 ; i--){
            sort[arr[people[i]]-1] = people[i];
            arr[people[i]]--;
        }
        int idx = 0;
        int result = 0;
        for(int i = sort.length-1; i>=idx ; i--){
            if(i == idx){
                result++;
                break;
            }
            int cur = sort[i];
            if(limit - cur >= sort[idx]){
                idx++;
            }
            result++;
        }
        return result;
    }
}