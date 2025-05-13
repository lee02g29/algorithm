import java.util.*;
/*
  원리는 해시맵과 동일
*/
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int kind = 1;
        
        Arrays.sort(nums);
        
        int temp = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(temp != nums[i]) {
                kind++;
                temp = nums[i];
            }
        } // 이 코드가 폰켓몬 종류 수를 세는 코드
          // 정렬 이후, 다른 종류가 나올 때마다 종류수 + 1
        
        if((nums.length / 2) >= kind) answer = kind;
        else if((nums.length / 2) < kind) answer = nums.length / 2;
        // 종류 수가 마리 수 / 2보다 크면 마리 수 / 2를
        // 반대라면 종류 수를 사용
        
        return answer;
    }
}
