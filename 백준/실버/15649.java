import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int m;
	static int[] nums;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		n = Integer.parseInt( str[0] ); // n까지의 숫자
		m = Integer.parseInt( str[1] ); // m개를 고를 것
		visit = new boolean[n + 5]; // 숫자 사용 여부
		nums = new int[m]; // 현재까지 고른 숫자들
		
		Order(0); // 순열 찾기 시작
		
		bw.flush();
		bw.close();

	}
	
	public static void Order(int cnt) {
		if(cnt == m) { // 고른 숫자가 m개라면 순열 완성
			for(int i = 0; i < m; i++) {
				System.out.print(nums[i] + " "); // 순열 출력
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(visit[i] == true) continue; 
      // 이미 고른 숫자라면 패스
			
			nums[cnt] = i; 
      // 현재 고른 숫자의 개수 + 1을 인덱스로하여 배열에 저장하기 
			visit[i] = true; // 숫자 사용중 표시
			Order(cnt + 1); // 다음 숫자 고르러 가기
			
			visit[i] = false; // 숫자 반납
		}
	}
}
