import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() ); // 테스트케이스 개수
		
		long[] cases = new long[101]; // n번째 삼각형의 넓이를 저장할 배열. 
    // 숫자가 너무 커질 수 있으므로, long 배열을 이용.
		
		cases[1] = 1;
		cases[2] = 1;
		cases[3] = 1;
		cases[4] = 2;
		cases[5] = 2;		
		// 초기항 - 문제에 있음
    
		for(int i = 6; i <= 100; i++) { // 6번째 항부터
			cases[i] = cases[i - 5] + cases[i - 1]; 
      // 바로 이전의 삼각형의 넓이 + 5번째 이전의 삼각형의 넓이
		}
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt( bf.readLine() );
      // 테스트 케이스
			
			bw.write(cases[temp] + "\n"); // 출력하기
		}
		
		
		bw.flush();
		bw.close();

	}

}
