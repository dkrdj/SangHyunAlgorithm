import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Integer> num = new ArrayList<>();
		List<Character> pm = new ArrayList<>();
		int start = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0') {
				num.add(Integer.parseInt(str.substring(start, i)));
				pm.add(str.charAt(i));
				start = i+1;
			}
			if (i == str.length()-1) {
				num.add(Integer.parseInt(str.substring(start)));
			}
		}
		int cnt = 0;
		int ans = num.get(cnt);
		while (cnt < pm.size() && pm.get(cnt) != '-') {
			ans += num.get(++cnt);
		}
		while (cnt < pm.size()) {
			ans -= num.get(++cnt);
		}
		System.out.println(ans);
	}

}