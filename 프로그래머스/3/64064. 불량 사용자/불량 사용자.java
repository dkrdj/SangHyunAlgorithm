import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Integer> answer = new HashSet<>();
        getNumber(answer, 0, user_id, banned_id, 0);
        return answer.size();
    }
    
    public void getNumber(Set<Integer> answer, int visited, String[] user_id, String[] banned_id, int idx){
        if(banned_id.length == idx){
            answer.add(visited);
            return;
        }
        for(int i = 0; i < user_id.length; i++){
            if(isCorrect(user_id[i], banned_id[idx]) &&
              (visited & (1<<i)) == 0){
                visited += (1<<i);
                getNumber(answer, visited, user_id, banned_id, idx+1);
                visited -= (1<<i);
            }
        }
    }
    
    public boolean isCorrect(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i = 0; i < s1.length(); i++){
            if(c2[i] == '*')
                continue;
            if(c1[i] != c2[i])
                return false;
        }
        return true;
    }
}