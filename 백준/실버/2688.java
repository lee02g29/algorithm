import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt( bf.readLine() );

		for(int t = 0; t < test; t++) {
			int n = Integer.parseInt( bf.readLine() );
			long[][] dp = new long[n][10]; // n번째로 고르는, 0~9까지의 숫자
			long ans = 0; // n자리의 개수
			
			for(int i = 0; i < 10; i++) {
				dp[0][i] = 1; // 0자리에서 0~9를 고르는 방법은 1가지
			}
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < 10; j++) {
					for(int k = 0; k <= j; k++) {
						dp[i][j] += dp[i-1][k];
            // i번째 자리에서 숫자 j를 고르는 방법 
            // = 이전 숫자를 고를 때, j보다 작거나 같은 숫자를 고른다
					}
				}
			}
			
			for(int i = 0; i < 10; i++) {
				ans += dp[n-1][i]; 
        // n-1번째 자리 숫자를 고르는 방법의 수 다 더하기
			}
			
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
