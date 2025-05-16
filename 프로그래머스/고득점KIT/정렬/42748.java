import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    
        for(int i = 0; i < commands.length; i++) {
            for(int j = 0; j < 3; j++) {
              // 문제의 인덱스는 1부터 시작
                int s = commands[i][0] - 1; // 시작점
                int e = commands[i][1] - 1; // 종료점
                
                int pos = commands[i][2] - 1;
                // 탐색 지점
                int[] temp = new int[e - s + 1];
                // 잘린 배열. 크기는 시작점과 종료지점의 차이 + 1
                
                for(int l = 0; l < e - s + 1; l++) {
                    temp[l] = array[l+s];
                } // 시작지점~종료지점 복사
                // 추천 함수 : Arrays.copyOfRange
                
                Arrays.sort(temp); // 정렬
                
                answer[i] = temp[pos];
                // 탐색 지점 숫자 찾기
            }
        }
        
        return answer;
    }
}
