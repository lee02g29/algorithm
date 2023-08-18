import java.util.*;
import java.io.*;

class Main {

	static int[][] score;
	static int[] nx;
	static int[] ny;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		nx = new int[15];
		ny = new int[15];
        	// 경기 순서용 배열
		
		int cnt = 0;
		// 혹시 몰라 만든 변수
    
		for(int l = 0 ; l < 6; l++) {
			for(int k = l + 1; k < 6; k++) {
				nx[cnt] = l;
				ny[cnt] = k;
				cnt++;
			}
		} // 경기 순서 정하기
       		// 총 n * ( n - 1 ) 이므로 15번의 경기가 나옴
		
		for(int i = 0; i < 4; i++) { // 총 네 개의 결과판
			String[] str = bf.readLine().split(" ");
			
			score = new int[6][3];
            		// 각 나라별 결과
			
			int temp = 0; // 결과 저장용 개수 세기 변수
			int wins = 0; // 모든 나라의 승리 횟수
			int draws = 0; // 모든 나라의 무승부 횟수
			int loses = 0; // 모든 나라의 패배 횟수
			
			flag = false; // 모든 결과를 재현할 수 있는지 여부
            		// 일단 안된다고 보기
			
			for(int l = 0 ; l < 6; l++) {
				for(int k = 0; k < 3; k++) {
					score[l][k] = Integer.parseInt( str[temp++] );
					if(k == 0) wins += score[l][0];
					if(k == 1) draws += score[l][1];
					if(k == 2) loses += score[l][2];
                    			// 결과판을 저장하는 동시에, 승리 무승부 패배 횟수 저장하기
				}
			} // 결과판 저장
			
			if( wins + draws + loses != 30 ) flag = false;
            		// 전부 합쳤을 때 30이 아니면 일단 안됨
            		// 총 경기수 = 15 * 2 = 30
			
			else recur(0); 
            		// 경기수가 일단 맞다면 시뮬레이션을 시작하기
			
			if(flag) bw.write(1 + " ");
			else bw.write(0 + " ");
            		// 시뮬레이션 결과에 따라 답 출력하기
		}

		bw.flush();
		bw.close();

	}

	public static void recur(int idx) {
    	// 첫번째 경기부터 시작하여 시뮬레이션하기
    
		if(flag) return;
		if(idx == 15) { 
        	// 15번째 경기까지 무사히 시뮬레이션이 가능하다면
        	// = 모든 값을 0으로 만들 수 있다면
			flag = true; // flag를 true로
			return;
		}
		
		int team_A = nx[idx];
		int team_B = ny[idx];
        	// 이번 경기하는 나라들

        	// 모든 결과 공통
        	// 둘 다 줄일 수 있는 값이 있는 경우에만 다음 경기 시뮬레이션을 호출
        	// 한쪽만 있으면 호출 안됨 = 한쪽만 있으면, 이번 경기 결과는 불가능한 경우
    
		if(score[team_A][0] > 0 && score[team_B][2] > 0) {
        	// A가 이기고, B가 졌을 경우
			score[team_A][0]--;
			score[team_B][2]--;
            		// A의 승리 점수 감소, B의 패배 점수 감소
			
			recur(idx + 1); // 다음 경기 시뮬
			
			score[team_A][0]++;
			score[team_B][2]++;
            		// 원상 복귀
		}
		
		if(score[team_A][1] > 0 && score[team_B][1] > 0) {
        	// A와 B가 무승부일 경우
			score[team_A][1]--;
			score[team_B][1]--;
            		// 둘 다 무승부 점수 감소
			
			recur(idx + 1);
            		// 다음 경기 시뮬
			
			score[team_A][1]++;
			score[team_B][1]++;
            		// 원상 복귀
		}
		
		if(score[team_A][2] > 0 && score[team_B][0] > 0) {
        	// A가 지고, B가 이겼을 경우
			score[team_A][2]--;
			score[team_B][0]--;
            		// A의 패배 점수 감소, B의 승리 점수 감소
			
			recur(idx + 1);
            		// 다음 경기 시뮬
			
			score[team_A][2]++;
			score[team_B][0]++;
            		// 원상 복귀 
		}		
	}

}
