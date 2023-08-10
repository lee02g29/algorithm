import java.io.*;
import java.util.*;

public class Main {
	static boolean[] check; // 방문 여부
	static int[] nums; // 규영이의 카드 순서
	static int win; // 이긴 숫자
	static int lose; // 진 숫자
	static int[] order; // 인영이의 카드 순서

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt( bf.readLine() );
		
		for(int t = 1; t <= test; t++) {
			String[] str = bf.readLine().split(" ");
			nums = new int[9]; // 
			check = new boolean[19];
			order = new int[9];
			
			win = 0;
			lose = 0;
			
			for(int i = 0; i < 9; i++) {
				int temp = Integer.parseInt(str[i]);
				nums[i] = temp;
				check[temp] = true;
			} // 규영이의 숫자, 이미 방문했다고 처리하여 스킵하기
			
			find(0); // 0개의 카드를 고른 것부터 시작
			
			bw.write("#" + t + " " + win + " " + lose + "\n"); // 출력
		}

		bw.flush();
		bw.close();
	}
	
	public static void find(int cnt) {
		if(cnt == 9) { // 9개의 카드를 골랐음
			int s1 = 0; // 규영이 스코어
			int s2 = 0; // 인영이 스코어
			
			for(int i = 0; i < 9; i++) {
				if(nums[i] > order[i]) s1 += nums[i] + order[i];
				else s2 += nums[i] + order[i];
			} // 이긴 사람에게 카드 숫자의 합만큼 스코어를 주기
			
			if(s1 > s2) win++; // 이김
			else if(s2 > s1)lose++; // 짐
      // 무승부도 있지만 따로 처리 안함
			
			return;
			
		}
		
		for(int i = 1; i <= 18; i++) {
			if(check[i] == true) continue; 
      // 이미 방문했거나 규영이의 카드일 때, 스킵
			
			check[i] = true; // 이번 카드는 사용중
			
			order[cnt] = i; // 카드 숫자 저장
			
			find(cnt + 1); // 다음 숫자 고르기
			
			check[i] = false; // 숫자 반납
			
		}
	}

}
