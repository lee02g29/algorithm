import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() ); // 테스트 케이스 개수
		
		long[] cases = new long[101]; // n번째 넓이를 저장할 배열
    // 100에 가서는 int의 범위를 넘는다
		
		cases[1] = 1;
		cases[2] = 1;
		cases[3] = 1;
    // 초기항
		
		for(int i = 4; i <= 100; i++) { // 
			cases[i] = cases[i - 2] + cases[i - 3];
      // 두 번째 이전의 삼각형의 넓이와 세 번째 이전의 삼각형의 넓이의 합
		}
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt( bf.readLine() ); // 테스트케이스
			
			bw.write(cases[temp] + "\n"); // 출력하기
		}
		
		
		bw.flush();
		bw.close();

	}

}
