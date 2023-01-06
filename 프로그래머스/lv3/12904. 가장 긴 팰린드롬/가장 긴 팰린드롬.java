import java.util.*;

class Solution
{
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        int ans = 1;
        for(int i = 0 ; i < arr.length ; i++){
            int cnt = 1;
            for(int j = 1; i - j >= 0 && i + j < arr.length; j++){
                if(arr[i - j] != arr[i + j])
                    break;
                cnt += 2;
            }
            ans = Math.max(ans, cnt);
            cnt = 0;
            for(int j = 0; i - j >= 0 && i + j+1 < arr.length; j++){
                if(arr[i - j] != arr[i + j+1])
                    break;
                cnt += 2;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}