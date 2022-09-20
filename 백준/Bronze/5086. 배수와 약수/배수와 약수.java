import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == 0 && B == 0) {
				break;
			}
			if (A != 0 && B % A == 0 && B / A > 1) {
				System.out.println("factor");
			} else if (B != 0 && A % B == 0 && A / B > 1) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
		}
	}

}