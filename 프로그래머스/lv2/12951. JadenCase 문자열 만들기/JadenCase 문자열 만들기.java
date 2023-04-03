
class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        s = s+"1";
        for(String word : s.split(" ")){
            if(word.length() >= 1)
                result = result.append(word.substring(0,1).toUpperCase());
            if(word.length() > 1)
                result.append(word.substring(1,word.length()).toLowerCase());
            result.append(" ");
        }
        return result.substring(0,s.length()-1).toString();
    }
}