import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] isPoss = new boolean[40001];
		int max = 0;
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= max; j++) {
				if (isPoss[j]) {
					que.add(Math.abs(a-j));
					que.add(a+j);
				} else if (isPoss[Math.abs(a - j)] || isPoss[a + j]) {
					que.add(j);
				}
			}
			while(!que.isEmpty())
				isPoss[que.poll()] = true;
			isPoss[a] = true;
			max += a;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int question = Integer.parseInt(st.nextToken());
			sb.append(isPoss[question] ? 'Y' : 'N').append("\n");
		}
		System.out.println(sb);

	}
}
