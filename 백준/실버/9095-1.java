import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int cnt;
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt( bf.readLine() ); // 테스트케이스 수
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt( bf.readLine() ); // 정수 n
			cnt = 0; // 경우의 수 초기화 -> 전역변수이기 때문에 n이 바뀔때마다 초기화 필요
			
			recur(0); 
			
			bw.write(cnt + "\n");
		}
    
		bw.flush();
		bw.close();

	}

	public static void recur(int sum) { // 완전탐색
		if(sum == n) { // 합이 n이라면
			cnt++; // 개수 추가
			return;
		} else if(sum > n) return; // 합이 n을 넘었다면 반환
		
		for(int i = 1; i <= 3; i++) { // 1부터 3까지의 수 고르기
			recur(sum + i); // 다음 탐색
		}
				
	}
}
