import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        char lastChar = words[0].charAt(words[0].length()-1);
        int idx = 0;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 2 ; i <= words.length ;i++){
            char curLastChar = words[i-1].charAt(words[i-1].length()-1);
            char curFirstChar = words[i-1].charAt(0);
                System.out.println(words[i-1]);
            
            if(lastChar != curFirstChar || !set.add(words[i-1])){
                System.out.println(words[i-1]);
                idx = i;
                break;
            }
            lastChar = curLastChar;
        }
        if(idx == 0)
            return new int[]{0,0};
        return new int[]{(idx-1)%n+1, (idx-1)/n+1};
    }
}