class Solution {
    public int solution(String name) {
        // ABCDE FGHIJ KLMNO PQRST UVWXY Z
        int answer = 0;
        int minMove = name.length() - 1;
        // 최소 이동횟수 = 초기값 오른쪽으로만 갈 때의 이동 횟수
        int cost = 0;
        // A에서 현재 알파벳으로 이동 하는 횟수의 합
        
        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            
            int gap = Math.min((c - 'A'), ('Z' - c + 1));
            cost += gap;   
        }
        
        if (cost == 0) { 
          // 엣지케이스 : 모두 A일 때. 이거 안하면 17번 테케 틀림
                minMove  = 0;
         }
        
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) != 'A') { // 현재 위치가 A가 아닐때.
                int next = i + 1;
                // A가 아닌 다음 위치를 찾음
                while(next < name.length() && name.charAt(next)== 'A') {
                    next++;
                } 

            
                // 돌아가기. 
                // 방법은 두가지 
                // 1. 현재 위치에서 0으로 돌아가고, 다시 끝에서 next까지 가는 횟수
                // i + i + (L - next_idx))
                // 2. next의 위치에서 끝으로 돌아가고, 다시 0에서 현재 위치까지 오는 횟수
                // (L - next_idx) + (L - next_idx) + i)
                // 둘 중 최소값을 채택, 같은 값은 서로 지운 결과가 아래의 식
                int back = Math.min(i , name.length() - next);
              
                // 계속 가기
                // A를 건너뛰고, 나머지를 처리
                int go = i + (name.length() - next);

                minMove = Math.min(minMove, go + back);
                // 기존의 값과 (기본 비용 + 추가 왕복의 값)을 비교
            }
        }
        
        // System.out.println(minMove);
        // System.out.println(cost + minMove);
        
        answer = cost + minMove;
        // 알파벳을 만드는 횟수와 최소 횟수를 더함
        
        return answer;
    }
}
