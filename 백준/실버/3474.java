import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		int n = Integer.parseInt( bf.readLine() ); // 테스트 케이스 수
		
		for(int i = 0; i < n ; i++) {
			int num = Integer.parseInt( bf.readLine() ); // 이번 숫자
			int fives = 0; // 5의 개수
      // 2와 5의 곱으로 0을 만들지만, 항상 5의 개수가 더 작기 때문에 5의 개수만 세기
			
			for(int j = 5; j <= num; j = j * 5) {	// 5의 제곱수들로 탐색
				fives += num / j; // j로 나눈 몫의 개수 만큼 j가 있다. = 5의 개수가 그만큼 있다
			}
			
			bw.write(fives + "\n"); // 5의 개수를 출력
		}
		
		bw.flush();
		bw.close();

	}
}
