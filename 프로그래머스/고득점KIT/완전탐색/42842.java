class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        // 총 타일의 수
        for(int i = 1 ; i <= i * i; i++) {
        // 가로 * 세로 = 총 타일 수인 숫자를 탐색. 제곱근까지만 탐색해도 ok
            if(sum % i != 0) continue;
            // 가로 * 세로를 곱한 것이 총 타일의 수여야함
            
            int j = sum / i;
            // 가로와 세로를 구함
            
            if( ( i - 1 ) * 2 + ( j - 1 ) * 2 == brown) {
                answer[0] = Math.max(i, j);
                answer[1] = Math.min(i, j);
            }
            // 둘레의 길이와 다르게, 공유하는 타일이 있기 때문에
            // 가로에서 하나, 세로에서 하나를 빼고 둘레의 길이를 구함
            // 그것이 갈색의 개수와 같을 때가 정답
            // 문제의 조건에 따라, 앞쪽이 더 길어야함
        }
        
        return answer;
    }
}
