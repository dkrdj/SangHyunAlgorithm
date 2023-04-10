import java.util.*;

class Solution {
    public int solution(int[] arr) {
        List<Integer> primeList = new ArrayList<>();
        boolean[] isPrime = new boolean[101];
        for(int i = 2 ; i <= 100 ; i++){
            isPrime[i] = true;
        }
        for(int i = 2 ; i * i <= 100 ; i++){
            if(isPrime[i]){
                for(int j = i ; j * i <= 100 ; j++){
                    isPrime[i*j] = false;
                }
            }
        }
        for(int i = 2 ; i <= 100 ; i++){
            if(isPrime[i]){
                primeList.add(i);
            }
        }
        
        List<Integer> lcm = new ArrayList<>();
        
        for(int num : arr){
            for(int lcmNum : lcm){
                if(num % lcmNum == 0){
                    num /= lcmNum;
                }
            }
            for(int i = 0 ; i < primeList.size() ; i++){
                int prime = primeList.get(i);
                while(num % prime == 0){
                    num /= prime;
                    lcm.add(prime);
                }
            }
        }
        int result = 1;
        for(int lcmNum : lcm){
            result *= lcmNum;
        }
        return result;
    }
}