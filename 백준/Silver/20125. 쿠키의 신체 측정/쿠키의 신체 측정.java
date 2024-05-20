import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int row = 0;
        int col = 0;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*') {
                    row = i + 1;
                    col = j;
                    break outer;
                }
            }
        }
        int left = 0;
        for (int i = col - 1; i >= 0; i--) {
            if (arr[row][i] == '*') {
                left++;
            } else {
                break;
            }
        }
        int right = 0;
        for (int i = col + 1; i < N; i++) {
            if (arr[row][i] == '*') {
                right++;
            } else {
                break;
            }
        }
        int waist = 0;
        for (int i = row + 1; i < N; i++) {
            if (arr[i][col] == '*') {
                waist++;
            } else {
                break;
            }
        }
        int leftLeg = 0;
        for (int i = row + waist + 1; i < N; i++) {
            if (arr[i][col - 1] == '*') {
                leftLeg++;
            } else {
                break;
            }
        }
        int rightLeg = 0;
        for (int i = row + waist + 1; i < N; i++) {
            if (arr[i][col + 1] == '*') {
                rightLeg++;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(row + 1).append(' ').append(col + 1).append("\n")
                .append(left).append(' ')
                .append(right).append(' ')
                .append(waist).append(' ')
                .append(leftLeg).append(' ')
                .append(rightLeg);
        System.out.println(sb);
    }
}