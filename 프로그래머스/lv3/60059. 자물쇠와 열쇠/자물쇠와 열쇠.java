class Solution {


    public boolean solution(int[][] key, int[][] lock) {
        for (int m = 0; m < 4; m++) {
            key = rotate(key);
            for (int i = -1; i < 2; i += 2) {
                for (int j = -1; j < 2; j += 2) {
                    for (int k = 0; k < lock.length; k++) {
                        for (int l = 0; l < lock.length; l++) {
                            int[] move = {i * k, j * l};
                            if (check(lock, key, move)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean check(int[][] lock, int[][] key, int[] move) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (i >= move[0] && j >= move[1] && i - move[0] < key.length && j - move[1] < key.length) {
                    if (key[i - move[0]][j - move[1]] + lock[i][j] != 1) {
                        return false;
                    }
                } else {
                    if (lock[i][j] != 1)
                        return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate(int[][] key) {
        int length = key.length;
        int[][] newKey = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newKey[j][length - i - 1] = key[i][j];
            }
        }
        return newKey;
    }
}