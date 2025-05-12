import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        // 두 배열 다 정렬하기
        
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        } // 앞에서부터 비교하면서, 다른게 있다면 그 사람은 완주를 못한 것
        
        if(answer.equals("")) {
            answer = participant[participant.length - 1];
        } // 만약 위에 반복문에서 걸리지 않았다면 마지막 사람이 완주하지 못함
        
        return answer;
    }
}
