import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		int credit = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
			credit += arr[i];
			String str = st.nextToken();
			double score = 0;
			switch (str.charAt(0)) {
			case 'A':
				score = 4;
				break;
			case 'B':
				score = 3;
				break;
			case 'C':
				score = 2;
				break;
			case 'D':
				score = 1;
				break;
			case 'F':
				score = 0;
				break;
			}
			if (str.length() == 2) {
				switch (str.charAt(1)) {
				case '+':
					score += 0.3;
					break;
				case '-':
					score -= 0.3;
					break;
				}
			}
			arr[i] *= score;
		}
		double sum = 0;
		for (double d : arr) {
			sum += d;
		}
		double ans = sum / credit;

		System.out.println(String.format("%.2f", ans));
	}

}