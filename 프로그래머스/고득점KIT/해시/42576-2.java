import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        // 키 값은 이름, value는 횟수
        
        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                map.replace(participant[i] , map.get(participant[i]) + 1);
            }
            else map.put(participant[i] , 1);
            
        } // 참여자의 이름을 키값으로 해시맵 생성. 동명이인이 있을 수 있으므로 횟수로 체크
        
        for(int i = 0; i < completion.length; i++) { // 완주자의 이름으로 맵을 탐색
            if (map.containsKey(completion[i])) {
                
                if(map.get(completion[i]) == 1) { // 한명만 있다면 제거
                    map.remove(completion[i]);
                } else { // 1명 이상이라면 동명이인이므로 -1
                     map.replace(completion[i] , map.get(completion[i]) - 1);
                }             
            }
          }
        
        for(String key : map.keySet()) {
            answer = key;
        } // 해시맵에 남은 키 값이 완주를 못한 사람
        
        return answer;
    }
}
