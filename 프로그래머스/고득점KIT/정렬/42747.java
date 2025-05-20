import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int highest = 0;

        Arrays.sort(citations); // 이분 탐색용 정렬
        highest = citations[citations.length - 1];
        // 숫자 중 최대값
        
        for(int i = 0; i < highest; i++) { // 최대값까지 탐색

            int left = 0;
            int right = citations.length - 1;

            while(left <= right) {
                int mid = (left+right) / 2;

                if(citations[mid] >= i) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            } // lowerbound, target 보다 크거나 같은 숫자의 인덱스 반환

            if(citations.length - left >= i) answer = i;
          // 개수 세고, i개 이상이면 갱신
        }

        
       return answer;
    }
}
