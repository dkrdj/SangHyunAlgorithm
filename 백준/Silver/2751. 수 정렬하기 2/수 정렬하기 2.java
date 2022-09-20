import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i : A) {
			list.add(i);
		}
		Collections.sort(list);
		for(int i = 0 ; i < N ; i++) {
			bw.write(String.valueOf(list.get(i)));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}