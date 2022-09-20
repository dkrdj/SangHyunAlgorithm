import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> myMap = new HashMap<>();
			List<String> strList = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String str = st.nextToken();

				if (myMap.containsKey(str)) {
					myMap.put(str, myMap.get(str) + 1);
				} else {
					myMap.put(str, 1);
					strList.add(str);
				}
			}
			long sum = 1;
			for (int j = 0; j < strList.size(); j++) {
				sum *= (myMap.get(strList.get(j)) + 1);
			}
			System.out.println(sum - 1);
		}

	}

}