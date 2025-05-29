class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] dict = {'A', 'E', 'I', 'O', 'U'};
        // 글자 인덱스 추출용
        int[] cnt = {781, 156, 31, 6, 1};
        // 자리별 가중치, 등비수열의 합.
        
        for(int i = 0; i < word.length(); i++) {
            int temp = 0; // 문자의 인덱스
            for(int j = 0; j < 5; j++) {
                if(word.charAt(i) == dict[j]) {
                    temp = j; // 인덱스 구함
                }
            }
            answer += (temp * cnt[i]) + 1;
            // 현재 자리의 인덱스 * 가중치 + 1
            // 문자에 따라 건너뛰는 단어들 수 구하기
        }
        
        return answer;
    }
}
