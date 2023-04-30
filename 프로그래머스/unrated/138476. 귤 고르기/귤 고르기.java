import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        PriorityQueue<Fruit> pq = new PriorityQueue<>((o1,o2)->o2.count-o1.count);
        Map<Integer, Fruit> map = new HashMap<>();
        for(int tanger : tangerine){
            Fruit fruit = map.get(tanger);
            if(fruit == null){
                fruit = new Fruit(tanger,0);
            }
            fruit.count = fruit.count+1;
            map.put(tanger, fruit);
        }
        pq.addAll(map.values());
        int answer = 0;
        int count = 0;
        while(count < k){
            count += pq.poll().count;
            answer++;
        }
        return answer;
    }
}
class Fruit{
    int size;
    int count;
    public Fruit(int size, int count){
        this.size = size;
        this.count = count;
    }
}