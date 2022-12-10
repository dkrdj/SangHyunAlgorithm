import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words){
        boolean[] visited = new boolean[words.length];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(begin, 0));
        while(!que.isEmpty()){
            Node curNode = que.poll();
            String cur = curNode.str;
            int cnt = curNode.cnt;
            System.out.println(cur);
            for(int i = 0 ; i < words.length ; i++){
                if(!visited[i] && isPoss(cur, words[i])){
                    visited[i] = true;
                    que.offer(new Node(words[i], cnt+1));
                    System.out.println(words[i]);
                    if(words[i].equals(target)){
                        return cnt + 1;
                    }
                }
            }
                
        }
        return 0;
    }
    
    
    
    public boolean isPoss(String begin, String word){
        int count = 0;
        char[] char1 = begin.toCharArray();
        char[] char2 = word.toCharArray();
        
        for(int i = 0 ; i < char1.length ; i++){
            if(char1[i] != char2[i])
                count++;
        }
        System.out.println(count);
        return count == 1;
    }
}
class Node{
    public String str;
    public int cnt;
    
    public Node(){}
    
    public Node(String str, int cnt){
        this.str = str;
        this.cnt = cnt;
    }
}