import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() ); // 2 * n 크기의 직사각형 
		
		int[] nums = new int[1001]; // 1~1000까지의 방법의 수를 저장할 배열

    // 초기항
		nums[1] = 1; // 2 * 1일 때 경우의 수
		nums[2] = 2; // 2 * 2일 때 경우의 수
		
		for(int i = 3; i <= n; i++) {
			nums[i] = ( nums[i-1] % 10007 + nums[i-2] % 10007 ) % 10007;
      // 2 * (n - 1)일 때 경우의 수 + 2 * ( n - 2 )의 경우의 수
      // (a + b) % 10007 = ( a % 10007 + b % 10007 ) % 10007
		}
		
		bw.write(nums[n] + "\n");
		// 2 * n일 때, 경우의 수 % 10007 출력
		
		bw.flush();
		bw.close();

	}

}
