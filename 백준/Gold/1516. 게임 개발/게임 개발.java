import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer>[] childQue = new LinkedList[N + 1];
		Queue<Integer>[] parentQue = new LinkedList[N + 1];
		int[] time = new int[N + 1];
		int[] parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			childQue[i] = new LinkedList<>();
			parentQue[i] = new LinkedList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			while (num != -1) {
				parent[i]++;
				parentQue[i].add(num);
				childQue[num].add(i);
				num = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (parent[i] == 0)
				que.add(i);
		}

		int[] sum = new int[N + 1];
		while (!que.isEmpty()) {
			int tmp = que.poll();
			PriorityQueue<Integer> myQue = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
			while (!parentQue[tmp].isEmpty()) {
				myQue.add(sum[parentQue[tmp].poll()]);
			}
			if (!myQue.isEmpty())
				sum[tmp] += myQue.poll();
			sum[tmp] += time[tmp];
			while (!childQue[tmp].isEmpty()) {
				int child = childQue[tmp].poll();
				if (--parent[child] == 0)
					que.add(child);
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(sum[i]).append("\n");
		}
		System.out.println(sb);
	}
}
