import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] nums = new Integer[numbers.length];
        // 사용자 정의 클래스를 Integer로 해서, Integer 배열이 필요했음
        
        for(int i = 0; i < numbers.length; i++) {
            nums[i] = (Integer)(numbers[i]);
        }

        Arrays.sort(nums, new maxNumber());
        // 사용자 정의 클래스대로 정렬
        
        for(int i = 0; i < numbers.length; i++) {
            answer += nums[i];
        } // 앞에서부터 순서대로 붙이기
        
        if(answer.charAt(0) == '0') {
            answer = "0";
        } // 모두 0인 경우 0으로 처리
        
        return answer;
    }
    
    public class maxNumber implements Comparator<Integer> {
    
        @Override 
        public int compare(Integer x, Integer y) {
            String s1 = Integer.toString(x);
            String s2 = Integer.toString(y);

            return (s2 + s1).compareTo(s1 + s2);
            // 두 숫자를 합치고, 이를 사전순의 반대로 정렬
        }
    }
}






     
