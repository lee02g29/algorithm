import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] check;
	static int[][] synergy;
	static int n;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt( bf.readLine() );
		
		for(int t = 1; t <= test; t++) {
			n = Integer.parseInt( bf.readLine() );
			
			synergy = new int[n][n]; // 시너지
			check = new boolean[n];
      // 재료 사용 여부, 안 쓴건 다른 요리에 씀
			min = Integer.MAX_VALUE; // 맛 차이 최소치

			for(int i = 0; i < n; i++) {
				String[] str = bf.readLine().split(" ");
				
				for(int j = 0; j < n; j++) {
					synergy[i][j] = Integer.parseInt( str[j] );
				}
			} // 시너지 입력
			
			find(0, 0); // 0개 고름, 0부터 시작함
			
			bw.write("#" + t + " " + min + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static void find(int cur, int start) {
		if(cur == n / 2) { // 재료를 n/2개를 골랐음
			int score_1 = 0;
			int score_2 = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(check[i] == false || check[j] == false) continue;
          // 고르지 않은 재료는 확인 안함
					if(i == j) continue; // 같은 건 확인 안함
					
					score_1 += synergy[i][j];
				}
			} // 고른 재료들로 맛 수치 - 요리 A
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(check[i] == true || check[j] == true) continue;
					if(i == j) continue;
					
					score_2 += synergy[i][j];
				}
			} // 고르지 않은 재료들로 맛 수치 - 요리 B
			
			if(min > Math.abs(score_1 - score_2))
					min = Math.abs(score_1 - score_2);
			// 차이 갱신
			
			return;
		}
		
		for(int i = start; i < n; i++) {
			check[i] = true; // 고른 재료 체크
			find(cur + 1, i + 1); // 다음 재료 고르기
			
			check[i] = false; // 재료 사용 반환
		}
	}



}
