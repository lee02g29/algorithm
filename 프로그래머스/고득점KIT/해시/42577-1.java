import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        // 정렬
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) answer = false;
        }
        // 이번 문자열과 다음 문자열을 비교하여 접두사인지 비교.
      
        // 앞에서부터 비교하고 짧은 문자열이 먼저 나오기 때문에,
        // 어떤 문자열이 다음 문자열의 접두사가 아니라면 그 이후 값들도 연속된 문자열일 수 없음

        return answer;
    }
}
