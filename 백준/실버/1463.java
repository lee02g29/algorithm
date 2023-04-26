import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		int n = Integer.parseInt( bf.readLine() ); // 시작 숫자
		int cnt = 0; // 최단 횟수
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] nums = new boolean[n+1]; // 방문처리용 bool 배열
		
		for(int i = 0; i <= n; i++) { // 모든 숫자는 아직 방문한 적이 없음
			nums[i] = false; 
		}
		
		queue.add(n); // 최초의 값을 큐에 넣기
		
    // 트리를 매우 단순화하여 구현한 것, cnt는 트리의 깊이이며, 
    // size만큼 도는 이유는 현재 트리 레벨에 해당하는 숫자들만 확인하기 위함
    
		while(!queue.isEmpty()) { // 큐가 비지 않은 동안 반복
			int size = queue.size(); // 현재 큐의 사이즈

			while(size-- > 0) { // 큐 사이즈 만큼 반복

				int cur = queue.peek(); // 큐 맨 앞의 숫자
				queue.remove();
				
				if(cur == 1) { // 1이라면 횟수를 출력
					bw.write(cnt + "\n");
				}
				
				if(cur % 3 == 0 && nums[cur / 3] == false) { // 3으로 나누어 떨어지면서, 이미 나왔던 숫자가 아니라면
					queue.add( cur / 3 ); // 3으로 나눈 값 큐에 넣기
					nums[ cur / 3 ] = true; // 방문처리하기
				}
				
				if(cur % 2 == 0 && nums[cur / 2] == false) { // 2으로 나누어 떨어지면서, 이미 나왔던 숫자가 아니라면
					queue.add( cur / 2 ); // 2로 나눈 값 큐에 넣기
					nums[ cur / 2 ] = true; // 방문처리하기
				}
				
				if(cur - 1 >= 1 && nums[cur - 1] == false) { // 1을 뺀 값이 1과 같거나 크고, 이미 나왔던 숫자가 아니라면(마이너스 인덱스 방지)
					queue.add( cur - 1 ); // 1을 뺀 값 큐에 넣기
					nums[ cur - 1 ] = true; // 방문 처리하기
				}
				
			}			
			cnt++; // 횟수 증가
		}
		
		bw.flush();
		bw.close();
	}
}
