import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[10001];
		for (int i = 0; i < N; i++) {
			A[Integer.parseInt(br.readLine())]++;
		}
		br.close();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i < 10001; i++) {
			while (A[i]-- > 0) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
	}
}