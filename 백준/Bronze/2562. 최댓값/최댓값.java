import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[9];
		for(int i = 0 ; i < 9 ; i++) {
			A[i] = sc.nextInt();
		}
		int MAX = 0;
		int idx = 0;
		for(int i = 0 ; i < 9 ; i++) {
			if(A[i]>MAX) {
				MAX = A[i];
				idx = i;
			}
		}
		System.out.println(MAX);
		System.out.println(idx+1);
	}
}