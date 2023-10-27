import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[][] dp = new int[n][10]; 
    // n - 1번째 자리수의 마지막 숫자가 0~9일때 경우의 수
    
		int ans = 0;
		
		for(int i = 0; i <= 9; i++) {
			dp[0][i] = 1;
		} // 길이가 1일 때 초기항
		
		for(int i = 1; i < n; i++) { // n -1 자리수
			for(int j = 0; j <= 9; j++) { // 마지막 수 j
				for(int k = 0; k <= j; k++) { // 마지막수보다 작은 숫자 k
					dp[i][j] += dp[i-1][k]; 
					dp[i][j] %= 10007;
				}
        // 마지막숫자로 j가 오는 경우의 수
        // 이전 자리수에 j보다 작은 숫자가 오는 경우를 모두 더하기
        // 조건에 따라 10007로 나눈 나머지 저장
			}
		}
			
		for(int i = 0; i <= 9; i++) {
			ans += dp[n-1][i];
		} // 마지막 자리 수의 경우의 수 모두 더하기
			
		bw.write((ans % 10007) + "\n");
    // 10007로 나눈 나머지 출력
		
		bw.flush();
		bw.close();
	}
	

}
