import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int myArr[];
    static int checkArr[];
    static int check;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        myArr = new int[4];
        checkArr = new int[4];
        char[] A = new char[L];
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i]==0){
                check++;
            }
        }
        for(int i = 0 ; i < P ; i++){
            Add(A[i]);
        }
        int result = 0;
        if(check==4){
            result++;
        }
        for(int i = P ; i < L ; i++){
            Remove(A[i-P]);
            Add(A[i]);
            if(check==4){
                result++;
            }
        }
        System.out.println(result);
        br.close();
    }
    
    public static void Add(char c){
        switch (c){
            case 'A':
                myArr[0]++;
                if (myArr[0]==checkArr[0])
                    check++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1]==checkArr[1])
                    check++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2]==checkArr[2])
                    check++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3]==checkArr[3])
                    check++;
                break;
        }
    }

    public static void Remove(char c){
        switch (c){
            case 'A':
                if (myArr[0]==checkArr[0])
                    check--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1]==checkArr[1])
                    check--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2]==checkArr[2])
                    check--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3]==checkArr[3])
                    check--;
                myArr[3]--;
                break;
        }
    }
}
