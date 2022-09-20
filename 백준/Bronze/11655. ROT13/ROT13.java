import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 65 && c <= 90) {
				if(c+13<=90) {
					sb.append((char)(c+13));
				} else {
					sb.append((char)(c-13));
				}
			}else if (c >= 97 && c <= 122) {
				if(c+13<=122) {
					sb.append((char)(c+13));
				} else {
					sb.append((char)(c-13));
				}
			}else {
				sb.append(c);
			}
		}
		System.out.println(sb);
	}
}
