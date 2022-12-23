import java.util.*;

class Solution {
    static List<String> res;
    static int size;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1,o2)->o1[1].compareTo(o2[1]));
        size = tickets.length+1;

        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs(tickets, new boolean[tickets.length], 1, list, "ICN");
        String[] answer = new String[res.size()];
        for(int i = 0 ; i < res.size() ; i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    private boolean dfs(String[][] tickets, boolean[] visited, int idx, List<String> list, String now){
        if(list.size() == size){
            res = list;
            return true;
        }
        for(int i = 0 ; i < tickets.length ; i++){
            if(tickets[i][0].equals(now) && !visited[i]){
                visited[i] = true;
                list.add(tickets[i][1]);
                if(dfs(tickets, visited, idx+1, list, tickets[i][1]))
                    return true;
                list.remove(idx);
                visited[i] = false;
            }
        }
        return false;
    }
    
    // private static class Node{
    //     int idx;
    //     String str;
    //     Node(){};
    //     Node(int idx, String str){this.idx = idx; this.str = str;}
    // }
}