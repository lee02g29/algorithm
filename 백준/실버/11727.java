import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( ( bf.readLine() ) );
		int[] dp = new int[1001]; 
    // n + 1 하면 n = 1일때, 13번째 줄에 의해 오류남

    // 초기항
		dp[1] = 1; 
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = ( dp[i - 1] % 10007 + ( dp[i - 2] * 2 ) % 10007 ) % 10007; 
      // dp식 n-1일때 경우와 n-2의 경우 * 2를 합해서 계산
		}
		
		bw.write(dp[n] % 10007 + "\n"); // 마지막에도 10007로 나누어주기

		bw.flush();
		bw.close();

	}
	
}
