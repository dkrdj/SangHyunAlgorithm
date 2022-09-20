import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ansE = Integer.parseInt(st.nextToken()) - 1;
		int ansS = Integer.parseInt(st.nextToken()) - 1;
		int ansM = Integer.parseInt(st.nextToken()) - 1;
		int E = 0;
		int S = 0;
		int M = 0;
		int cnt = 1;
		while (!(ansE == E++ & ansS == S++ & ansM == M++)) {
			E %= 15;
			S %= 28;
			M %= 19;
			cnt++;
		}
		System.out.println(cnt);
	}

}