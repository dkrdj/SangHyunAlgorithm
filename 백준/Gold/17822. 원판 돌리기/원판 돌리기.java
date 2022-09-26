import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] arr;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            rotate(x, d, k);
            check();
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void check() {
        Queue<Node> que = new LinkedList<>();
        boolean isWork = false;
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= M; i++) {
                if (arr[k][i] != 0) {
                    int stand = arr[k][i];
                    boolean isSame = false;
                    que.offer(new Node(k, i));
                    while (!que.isEmpty()) {
                        Node curNode = que.poll();
                        for (int j = 0; j < 4; j++) {
                            int nr = curNode.r + dr[j];
                            int nc = curNode.c + dc[j];
                            if (nr > 0 && nr <= N) {
                                if (nc == 0 && arr[nr][M] == stand) {
                                    arr[nr][M] = 0;
                                    isSame = true;
                                    isWork = true;
                                    que.offer(new Node(nr, M));
                                } else if (nc == M + 1 && arr[nr][1] == stand) {
                                    arr[nr][1] = 0;
                                    isSame = true;
                                    isWork = true;
                                    que.offer(new Node(nr, 1));
                                } else if (nc >= 1 && nc <= M) {
                                    if (arr[nr][nc] == stand) {
                                        arr[nr][nc] = 0;
                                        isSame = true;
                                        isWork = true;
                                        que.offer(new Node(nr, nc));
                                    }
                                }
                            }
                        }
                    }
                    if (isSame) {
                        arr[k][i] = 0;
                    }
                }
            }
        }
        if (!isWork) {
            int sum = 0;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (arr[i][j] != 0) {
                        sum += arr[i][j];
                        cnt++;
                    }
                }
            }
            if (cnt != 0) {
                double avg = (double) sum / cnt;
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if (arr[i][j] != 0) {
                            if (arr[i][j] > avg) {
                                arr[i][j]--;
                            } else if (arr[i][j] < avg) {
                                arr[i][j]++;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void rotate(int x, int d, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int j = x; j <= N; j += x) {
            for (int i = 1; i <= M; i++) {
                deque.addLast(arr[j][i]);
            }
            if (d == 0) {
                for (int i = 0; i < k; i++)
                    deque.addFirst(deque.pollLast());
            } else {
                for (int i = 0; i < k; i++)
                    deque.addLast(deque.pollFirst());
            }
            for (int i = 1; i <= M; i++) {
                arr[j][i] = deque.pollFirst();
            }
        }
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

