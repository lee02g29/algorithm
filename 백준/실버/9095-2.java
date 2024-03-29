import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] cases = new int[11]; // 경우의 수를 저장할 배열 1~10까지
		cases[1] = 1; // 1을 만들 수 있는 경우의 수 1개
		cases[2] = 2; // 2를 만들 수 있는 경우의 수 2개
		cases[3] = 4; // 3을 만들 수 있는 경우의 수 4개
    		// 초기 항
		
		for(int i = 4; i < 11; i++) { // 4~10까지의 수 미리 구하기
			cases[i] = cases[i - 1] + cases[i - 2] + cases[i - 3];
     			// i를 만드는 경우의 수 = (i - 1에 1을 더하는 경우의 수) + (i - 2에 2를 더하는 경우의 수) + (i - 3에 3을 더하는 경우의 수)
		}
		
		int t = Integer.parseInt( bf.readLine() ); // 테스트 케이스의 개수
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt( bf.readLine() ); // n 
			
			bw.write(cases[n] + "\n"); // n을 만들 수 있는 경우의 수 출력
		}		
		
		bw.flush();
		bw.close();

	}

}
