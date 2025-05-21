import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] row = new int[sizes.length];
        int[] col = new int[sizes.length];
        // 더 긴 것만 모을 배열과 그외 나머지를 모을 배열
      
        for(int i = 0; i < sizes.length; i++) {
            for(int j = 0; j < 2; j++) {
                int max = Math.max(sizes[i][0], sizes[i][1]);
                int min = Math.min(sizes[i][0], sizes[i][1]);
                row[i] = max;
                col[i] = min;
                // 더 긴 것과 그렇지 않은 것을 분류
            }
        }
        
        Arrays.sort(row);
        Arrays.sort(col);
        // 오름차순 정렬
        
        answer = row[sizes.length - 1] * col[sizes.length - 1];
        // 둘 중 큰 값끼리 곱함
        return answer;
    }
}
