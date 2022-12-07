import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2)->o2-o1);
        int delCnt = 0;
        int insCnt = 0;
        for(String str : operations){
            String[] tmp = str.split(" ");
            String order = tmp[0];
            int number = Integer.parseInt(tmp[1]);
            
            if(order.equals("I")){
                minPQ.offer(number);
                maxPQ.offer(number);
                insCnt++;
            } else if(order.equals("D")){
                if(insCnt>delCnt){
                    if(number == 1){
                        minPQ.remove(maxPQ.poll());
                        delCnt++;
                    } else{
                        maxPQ.remove(minPQ.poll());
                        delCnt++;
                    }
                } else{
                    minPQ = new PriorityQueue<>();
                    maxPQ = new PriorityQueue<>((o1,o2)->o2-o1);
                    insCnt = 0;
                    delCnt = 0;
                }
            }
            for(int num : maxPQ){
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
            for(int num : minPQ){
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println("------------------0");
        }
        int[] answer = new int[2];
        if(insCnt>delCnt){
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        return answer;
    }
}