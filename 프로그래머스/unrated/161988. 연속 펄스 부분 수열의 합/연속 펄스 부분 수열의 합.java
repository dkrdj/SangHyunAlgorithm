import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int[] parse = new int[sequence.length];
        long[] s1 = new long[sequence.length];
        long[] s2 = new long[sequence.length];
        
        parse[0] = 1;
        s1[0] = sequence[0]*parse[0];
        s2[0] = -sequence[0]*parse[0];
        for(int i = 1 ; i < parse.length ; i++){
            parse[i] = -parse[i-1];
        }
        for(int i = 1 ; i < parse.length ;i++){
            s1[i] = sequence[i]*parse[i]+s1[i-1];
            s2[i] = -sequence[i]*parse[i]+s2[i-1];
        }
        // System.out.println(Arrays.toString(s1));
        // System.out.println(Arrays.toString(s2));
        long s1Max = -100001;
        int s1MaxIdx = -1;
        long s1Min = 500001;
        int s1MinIdx = -1;
        
        long s2Max = -100001;
        int s2MaxIdx = -1;
        long s2Min = 500001;
        int s2MinIdx = -1;
        for(int i = 0 ; i< parse.length ;i++){
            if(s1[i]>=s1Max){
                s1Max = s1[i];
                s1MaxIdx = i;
            }
            if(s1[i]<s1Min){
                s1Min = s1[i];
                s1MinIdx = i;
            }
            if(s2[i]>=s2Max){
                s2Max = s2[i];
                s2MaxIdx = i;
            }
            if(s2[i]<s2Min){
                s2Min = s2[i];
                s2MinIdx = i;
            }
        }
        long answer = 0;
        for(int i = 0 ; i < s1MaxIdx ; i++){
            answer = Math.max(answer, s1Max - s1[i]);
        }
        for(int i = s1MinIdx+1 ; i< s1.length ; i++){
            answer = Math.max(answer, s1[i] - s1Min);
        }
        for(int i = 0 ; i < s2MaxIdx ; i++){
            answer = Math.max(answer, s2Max - s2[i]);
        }
        for(int i = s2MinIdx+1 ; i< s2.length ; i++){
            answer = Math.max(answer, s2[i] - s2Min);
        }
        return Math.max(Math.max(s1Max,s2Max),answer);
    }
}