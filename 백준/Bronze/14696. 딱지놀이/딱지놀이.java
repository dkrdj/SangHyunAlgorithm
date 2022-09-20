import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] A = new int[5];
			for (int j = 0; j < a; j++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int[] B = new int[5];
			for (int j = 0; j < b; j++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			for (int j = 4; j >= 1; j--) {
				if(A[j]>B[j]) {
					sb.append("A\n");
					break;
				}
				else if(A[j]<B[j]) {
					sb.append("B\n");
					break;
				}
				else if(j==1) {
					sb.append("D\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
