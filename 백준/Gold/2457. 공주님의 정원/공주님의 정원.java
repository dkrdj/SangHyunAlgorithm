import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Flower {
    int start;
    int end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class Main {
    static int N;
    static int startDay = 301, endDay = 1201;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());
            int start = startM * 100 + startD;
            int end = endM * 100 + endD;
            if (start >= endDay || end <= startDay) {
                continue;
            }
            Flower flower = new Flower(start, end);
            list.add(flower);
        }
        list.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }
            return o1.start - o2.start;
        });
        int start = startDay;
        int end = 0;
        int answer = 0;
        int idx = 0;
        while (start < endDay) {
            boolean isNew = false;
            for (int i = idx; i < list.size(); i++) {
                Flower cur = list.get(i);
                if (cur.start > start) {
                    break;
                }
                if (cur.end > end) {
                    end = cur.end;
                    idx = i + 1;
                    isNew = true;
                }
            }
            if (isNew) {
                start = end;
                answer++;
            } else {
                break;

            }
        }

        System.out.println(end < endDay ? "0" : answer);

    }
}
