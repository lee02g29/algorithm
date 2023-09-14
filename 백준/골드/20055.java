import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]); 
		int k = Integer.parseInt(str[1]);
		
		int[] belt = new int[2 * n]; // 컨베이어 벨트
		boolean[] robot = new boolean[n];  // 로봇
		
		str = bf.readLine().split(" ");
		
		for(int i = 0; i < 2 * n; i++) {
			belt[i] = Integer.parseInt(str[i]);
		} // 벨트 내구도

		int ans = 0; // 몇번째 단계인지
		int left = 0; // 벨트의 왼쪽
		int right = n; // 벨트의 오른쪽
    // 원형큐 처럼 생각하기
		
		while(k > 0) {
			ans++; // 단계 증가
			
			left--;
			right--;
      // 시계방향으로 회전
			
			if(left == -1) left = 2 * n - 1;
			if(right == -1) right = 2 * n - 1;
      // 회전시키다가 -1을 가리키면, 마지막 번호로 바꿔주기
			
			for(int i = n - 2; i >= 0; i--) { // 뒤에서부터, 내려놓는 위치는 제외
				if(robot[i]) { // 벨트 위에 로봇이 있다
					robot[i] = false; // 일단 그 위치서 제거하기
					if(i + 1 < n - 1) { // 다음 위치가 내려놓는 위치가 아니라면
						robot[i + 1] = true; // 그 위치에 로봇을 올려놓기
					}
				}
			} // 벨트 옮기기 
			
			for(int i = n - 2; i >= 0; i--) {
				if(robot[i]) { // 로봇이 있을 때,
					int next = left + i + 1; // 다음 위치
          // left + 위쪽 벨트 오프셋 + 1
					
					if(next >= 2 * n) next -= 2 * n;
          // 벨트 크기보다 커지면 벨트 크기만큼 빼기
					
					if(!robot[i + 1] && belt[next] > 0) { 
            // 다음 위치에 로봇이 없고 내구도가 있다
						robot[i] = false; 
						
						if(i + 1 < n - 1) robot[i + 1] = true;
						belt[next] --;
						// 벨트 옮기기와 다르게, 로봇 옮기기는 내구도를 소모함
						if(belt[next] == 0) k--; // 벨트 내구도가 0이 되면 k값 빼주기
					}
				}
			} // 로봇 옮기기
			
			if(!robot[0] && belt[left] > 0) { // 시작부분
				robot[0] = true; // 새 로봇 놓기
				belt[left]--; // 내구도 빼기
				
				if(belt[left] == 0) k--; // 벨트 내구도가 0이 되면 k값 빼주기
			}
			
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}

}
