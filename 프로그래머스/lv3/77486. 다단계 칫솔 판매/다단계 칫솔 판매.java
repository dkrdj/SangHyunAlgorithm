import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Person> map = new HashMap<>();
        for(int i = 0 ; i < enroll.length; i++){
            map.put(enroll[i], new Person(referral[i]));
        }
        for(int i = 0 ; i < seller.length ; i++){
            int money = amount[i] *100;
            Person person = map.get(seller[i]);
            sell(person, money, map);
        }
        int[] answer = new int[enroll.length];
        for(int i = 0 ; i < enroll.length ; i++){
            answer[i] = map.get(enroll[i]).money;
        }
        return answer;
    }
    public void sell(Person person, int money, Map<String, Person> map){
        if(person.referral.equals("-") || money/10 == 0){
            person.addMoney(money-money/10);
            return;
        }
        int diff = money / 10;
        person.addMoney(money-diff);
        sell(map.get(person.referral), diff, map);
    }
}
class Person{
    String referral;
    int money;
    public Person(String referral){
        this.referral = referral;
        this.money = 0;
    }
    public void addMoney(int add){
        this.money += add;
    }
}