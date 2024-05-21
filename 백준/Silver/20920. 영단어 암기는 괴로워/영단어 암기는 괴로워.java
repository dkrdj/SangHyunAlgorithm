import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Word> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                Word word = map.get(str);
                if (word == null) {
                    word = new Word(str, str.length(), 1);
                }
                word.cnt = word.cnt + 1;
                map.put(str, word);
            }
        }
        PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt != o2.cnt) {
                return o2.cnt - o1.cnt;
            } else if (o1.length != o2.length) {
                return o2.length - o1.length;
            } else {
                return o1.str.compareTo(o2.str);
            }
        });
        for (Word word : map.values()) {
            pq.offer(word);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!pq.isEmpty()) {
            bw.append(pq.poll().str).append("\n");
        }
        bw.flush();
    }
}

class Word {
    String str;
    int length;
    int cnt;

    public Word(String str, int length, int cnt) {
        this.str = str;
        this.length = length;
        this.cnt = cnt;
    }
}