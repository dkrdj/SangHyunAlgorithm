import java.util.*;

class Solution {
    static Person[] person;
    public int solution(int n, int[][] results) {
        person = new Person[n + 1];
        for(int i = 1;i <= n ; i++){
            person[i] = new Person(i);
        }
        for(int[] result : results){
            person[result[0]].win.add(result[1]);
            person[result[1]].lose.add(result[0]);
        }
        
        int answer = 0;
        
        for(int i = 1 ; i <= n ;i++){
            if(person[i].getSize() == n - 1)
                answer++;
        }
        
        return answer;
    }
    static class Person{
        int idx;
        Set<Integer> win;
        Set<Integer> lose;
        boolean winFlag, loseFlag;
        
        public Person(int idx){
            this.idx = idx;
            win = new HashSet<>();
            lose = new HashSet<>();
        }
        public Set<Integer> getWin(){
            if(!winFlag){
                List<Integer> list = new ArrayList<>(win);
                for(int i : win){
                    list.addAll(person[i].getWin());
                }
                win.addAll(list);
                winFlag = true;
            }
            return win;
        }
        public Set<Integer> getLose(){
            if(!loseFlag){
                List<Integer> list = new ArrayList<>(lose);
                for(int i : lose){
                   list.addAll(person[i].getLose());
                }
                lose.addAll(list);
                loseFlag = true;
            }
            return lose;
        }
        public int getSize(){
            if(!(winFlag && loseFlag)){
                getWin();
                getLose();
            }
            return win.size()+lose.size();
        }
    }
}

