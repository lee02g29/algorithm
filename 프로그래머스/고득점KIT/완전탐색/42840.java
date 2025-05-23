import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] score = new int[3];
        int count = 0;
        int max = -1;
        int[] s1 = {1, 2, 3, 4 ,5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 각각의 수포자가 찍는 패턴 배열화
        
        for(int i = 0; i < answers.length; i++) {
            if(s1[i % 5] == answers[i]) {
                score[0]++;
            }
            if(s2[i % 8] == answers[i]) {
                score[1]++;
            }
           if(s3[i % 10] == answers[i]) {
                score[2]++;
            }
          // 답이 맞을 때마자 세기
        }
        
        max = Math.max(score[0], Math.max(score[1], score[2]));
      // 셋 중 최대값 찾기
        
        for(int i = 0; i < 3; i++) {
            if(score[i] == max) {
                count++;
            }
        } // 최대값인 사람의 수 세기
        
        answer = new int[count];
      // 제일 많이 맞춘 사람 수 만큼 배열 만들기
        
        int loop = 0;
       for(int i = 0; i < 3; i++) {
            if(score[i] == max) {
                answer[loop] = i + 1;
                loop++;
            }
         // 제일 많이 맞춘 사람 배열에 넣기
         // 주의 인덱스는 0부터지만 사람은 1부터임
        }

        
        return answer;
    }
}
