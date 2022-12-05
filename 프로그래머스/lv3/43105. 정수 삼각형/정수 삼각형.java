import java.util.*;

class Solution {
    public int[][] max;
    
    public int solution(int[][] triangle) {
        int length = triangle.length;
        max = new int[length+1][length+1];
        for(int[] maxArr : max)
            Arrays.fill(maxArr, -1);
        
        int max = 0;
        for(int i = 0 ; i < length ; i++){
            max = Math.max(max, getMax(length - 1, i, triangle));
        }
        return max;
    }
    public int getMax(int r, int c, int[][] triangle){
        if(max[r][c] != -1){
            return max[r][c];
        }
        if(r == 0){
            return triangle[0][0];
        }
        if(c != 0 && c != r)
            return max[r][c] = triangle[r][c]+Math.max(getMax(r-1,c-1, triangle), getMax(r-1,c, triangle));
        else if(c == 0)
            return max[r][c] = triangle[r][c]+getMax(r-1,c, triangle);
        return max[r][c] = triangle[r][c]+getMax(r-1,c-1, triangle);
    }
}