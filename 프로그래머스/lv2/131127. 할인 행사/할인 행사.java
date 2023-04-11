import java.util.*;

class Solution {
    int count;
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> sale = new HashMap<>();
        Queue<String> saleQueue = new LinkedList<>();
        for(String stuff : want){
            sale.put(stuff, 0);
        }
        for(int i = 0 ; i < 10 ; i++){
            saleQueue.offer(discount[i]);
            if(sale.containsKey(discount[i])){
                sale.put(discount[i], sale.get(discount[i])+1);
            }
        }
        check(sale, want, number);
        for(int i = 10 ; i< discount.length ; i++){
            String endSale = saleQueue.poll();
            if(sale.containsKey(endSale))
                sale.put(endSale, sale.get(endSale)-1);
            if(sale.containsKey(discount[i])){
                sale.put(discount[i], sale.get(discount[i])+1);
            }
            saleQueue.offer(discount[i]);
            check(sale, want, number);
        }
        return count;
    }
    public void check(Map<String, Integer> sale, String[] want, int[] number){
        for(int i = 0 ; i < want.length ; i++){
            if(sale.get(want[i])<number[i])
                return;
        }
        count++;
    }
}