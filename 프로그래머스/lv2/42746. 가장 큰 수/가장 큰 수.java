import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        boolean flag = false;
        for(int number : numbers){
            if(number != 0)
                flag = true;
        }
        if(!flag)
            return "0";
        List<String> list = new ArrayList<>();
        for(int number : numbers){
            list.add(String.valueOf(number));
        }
        list.sort((o1,o2)->(o2+o1).compareTo(o1+o2));
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        return sb.toString();
    }
}