import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length; // 폰켓몬 마리수
        int type = 0; // 폰켓몬 종류의 수
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1 );
        } // [종류, 마리수]의 구조로 map
        
        type = map.size(); // 종류 세기
        
        if(type > size / 2) { // 종류가 마리수 / 2보다 크면
            answer = size / 2; // 마리수 / 2
        } else { // 그 외에는 종류 수
            answer = type;
        }
        
        return answer;
    }
}
