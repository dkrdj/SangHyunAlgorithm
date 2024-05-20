import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country selectedCountry = new Country();
        PriorityQueue<Country> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.gold != o2.gold) {
                return o2.gold - o1.gold;
            } else if (o1.silver != o2.silver) {
                return o2.silver - o1.silver;
            } else {
                return o2.bronze - o1.bronze;
            }
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int seq = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            if (seq == K) {
                selectedCountry.gold = gold;
                selectedCountry.silver = silver;
                selectedCountry.bronze = bronze;
            }
            pq.offer(new Country(gold, silver, bronze, seq));
        }
        int answer = 1;
        for (Country country : pq) {
            if (country.seq == K) {
                System.out.println(answer);
                return;
            }
            if (country.gold == selectedCountry.gold
                    && country.silver == selectedCountry.silver
                    && country.bronze == selectedCountry.bronze) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }
}

class Country {
    int gold;
    int silver;
    int bronze;
    int seq;

    public Country() {
    }

    public Country(int gold, int silver, int bronze, int seq) {
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.seq = seq;
    }
}