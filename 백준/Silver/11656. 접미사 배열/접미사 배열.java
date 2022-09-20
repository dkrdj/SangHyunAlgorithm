import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.substring(i));
		}
		Collections.sort(list);
		for(String s : list) {
			bw.write(s+"\n");
		}
		bw.flush();
	}
}
