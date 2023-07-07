import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++){
		   int n = Integer.parseInt(br.readLine());
		   int[][] arr = new int[n+1][2];
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   for(int i = 1 ; i <=n;i++){
		   	arr[i][0] = Integer.parseInt(st.nextToken());
		   }
		   st = new StringTokenizer(br.readLine());
		   for(int i = 1 ; i <=n;i++){
		   	arr[i][1] = Integer.parseInt(st.nextToken());
		   }
		   int[][] dp = new int[n+1][2];
		   dp[1][0] = arr[1][0];
		   dp[1][1] = arr[1][1];
		   for(int i = 2; i <=n;i++){
		       for(int j = 0 ; j <2;j++){
		           dp[i][j]= Math.max(dp[i-1][1-j],dp[i-2][1-j])+arr[i][j];
		       }
		   }
	    	System.out.println(Math.max(dp[n][0],dp[n][1]));
		}
	}
}