import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Meeting> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				if (o1.end != o2.end) {
					return o1.end - o2.end;
				} else {
					return o1.start - o2.start;
				}
			}
		});
		int cnt = 1;
		List<Integer> ans = new ArrayList<>();
		ans.add(list.get(0).end);
		while (cnt < list.size()) {
			if (ans.get(ans.size() - 1) <= list.get(cnt).start) {
				ans.add(list.get(cnt).end);
			}
			cnt++;
		}
		System.out.println(ans.size());
	}
}

class Meeting {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

}