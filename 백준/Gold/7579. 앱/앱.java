import java.io.*;
import java.util.*;

public class Main {
	static List<App> apps;
	static int N, M, maxprofit = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = -Integer.parseInt(st.nextToken());
		apps = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int weight = Integer.parseInt(st.nextToken());
			M += weight;
			apps.add(new App(weight));
		}
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int profit = Integer.parseInt(st.nextToken());
			sum += profit;
			apps.get(i).setProfit(profit);
		}
		Collections.sort(apps, new Comparator<App>() {

			@Override
			public int compare(App o1, App o2) {
				return Double.compare(o2.profit / (double) o2.weight, o1.profit / (double) o1.weight);
			}
		});

		int idx = 0;
		int totweight = 0;

		while (totweight <= M && idx < N) {
			totweight += apps.get(idx).weight;
			maxprofit += apps.get(idx).profit;
			idx++;
		}
		if (totweight > M) {
			maxprofit -= apps.get(idx - 1).profit;
		}
		knapsack(0, 0, -1);
		System.out.println(sum - maxprofit);

	}

	private static void knapsack(int weight, int profit, int idx) {
		if (weight <= M && profit > maxprofit) {
			maxprofit = profit;
		}
		if (promising(idx, weight, profit)) {
			knapsack(weight + apps.get(idx + 1).weight, profit + apps.get(idx + 1).profit, idx + 1);
			knapsack(weight, profit, idx + 1);
		}
	}

	private static boolean promising(int idx, int totweight, int profit) {
		double bound = profit;
		if (totweight > M || idx == N - 1)
			return false;
		while (totweight <= M && idx + 1 < N) {
			totweight += apps.get(idx + 1).weight;
			bound += apps.get(idx + 1).profit;
			idx++;
		}
		if (totweight > M) {
			bound += (M - totweight) * (double) apps.get(idx).profit / apps.get(idx).weight;
		}
		return bound > maxprofit;

	}
}

class App {
	int weight;
	int profit;

	public App(int weight) {
		this.weight = weight;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

}
