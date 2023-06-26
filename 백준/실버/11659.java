import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt( str[0] ); // 숫자 개수 
		int m = Integer.parseInt( str[1] ); // 합을 구해야하는 횟수 = 테스트 케이스 개수
		
		long[] nums = new long[n + 1]; // 숫자를 저장할 배열
		long[] sum = new long[n + 1]; // 누적합을 저장할 배열
		
		str = bf.readLine().split(" ");
		
		for(int i = 1; i <= n; i++) { 
			nums[i] = Integer.parseInt( str[i - 1] ); // 숫자들 저장
		}
		
		for(int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + nums[i]; // 누적합 계산
		}
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");
			
			int x = Integer.parseInt( str[0] ); // 시작 구간
			int y = Integer.parseInt( str[1] ); // 종료 구간
			
			bw.write(sum[y] - sum[x - 1] + "\n");	
      // 종료 구간의 누적합 - ( 시작 구간 - 1 )의 누적합
      // 시작 구간 - 1을 하는 이유는 시작 구간의 숫자도 더해야하기 때문
      // = 시작 구간의 숫자를 빼면 안되기 때문
		}		
		
		bw.flush();
		bw.close();

	}

}
