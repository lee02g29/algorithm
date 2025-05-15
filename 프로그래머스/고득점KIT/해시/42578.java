import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();    
            
        for(int i = 0; i < clothes.length; i++) {
          map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        } // 종류별 옷의 개수 체크
        
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        } 
        // 옷의 종류의 개수를 차수로 가지는 계수들의 합
        // ex) 3종류면 3차식

        answer = answer - 1;
        // 최고차항은 답에 포함 x 따라서 -1
        
        return answer;
    }
}
