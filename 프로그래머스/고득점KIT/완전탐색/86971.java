import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 99999999; // 적당히 큰 값
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        // 노드 저장용 리스트
        boolean[] visit = new boolean[n]; // 송전탑 방문 여부
        Queue<Integer> queue = new LinkedList<>(); // bfs용 큐
        int cnt = 0; // 방문한 송전탑 수
       
        for(int t = 0; t < n - 1; t++) { // 모든 전력망을 하나씩 제거하며 체크
            cnt = 0; // 방문수 초기화
            queue.clear(); // bfs 초기화
            visit = new boolean[n]; // 방문 여부 초기화
            arr = new ArrayList<>(); // 노드 초기화
            
            for(int v = 0; v < n; v++) {
                arr.add(new ArrayList<Integer>());
            } // 리스트 세팅
            
            for(int s = 0; s < n - 1; s++) {
                if(t == s) continue; // 전력망 하나 제거
                
                int start = wires[s][0] - 1;
                int end = wires[s][1] - 1;
                
                arr.get(start).add(end);
                arr.get(end).add(start);
              // 전력망 저장
            }
            
            queue.add(0); // 0(1)번부터 탐색 시작
            visit[0] = true;
            cnt++;
            // 방문여부 체크, 방문 수 체크
          
            while(!queue.isEmpty()) { // bfs
                int cur = queue.poll();
                
                for(int i = 0; i < arr.get(cur).size(); i++) {
                  // 현재 송전탑과 연결된 송전탑 탐색
                    int next = arr.get(cur).get(i);
                    
                    if(visit[next]) continue;
                  // 방문한 적 있는거 패스
                    queue.offer(next);
                    visit[next] = true;
                    cnt++;
                    // 다음거 방문
                }
            }

            answer = Math.min(answer, Math.abs(n - 2 * cnt));
          // 저장된 값과 n - cnt 와 n의 차이 비교 후 갱신
        }
        
        return answer;
    }
    
}
