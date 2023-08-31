import java.io.*;
import java.util.Arrays;


public class Main {
	static int[][] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		int n = Integer.parseInt( bf.readLine() );
		
		int[][] maps = new int[n ][n];
		int[][][] dp = new int[n ][n][3]; // [좌표][좌표][이동 방향 셋]
        // 가로 대각선 세로 순
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			String[] str = bf.readLine().split(" ");
			
			for(int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt( str[j] );
			}
		} // 입력받기

		
		dp[0][1][0] = 1; // 파이프의 끝은 0, 1이다
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 2; j < n; j++) { // 0,1 지점부터 시작이므로 2부터 가능하다
				
				if(maps[i][j] == 1) continue; // 벽은 못감
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
                // 가로, 가로는 이전 좌표에서 가로거나, 대각선인 경우에만 놓일 수 있음

				if(i == 0) continue; // 맨 윗줄이면 더 위로 못감
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
                // 세로, 세로는 이전 좌표에서 대각선이었거나 가로였을 때만 놓일 수 있음
				
				if(maps[i-1][j] == 1 || maps[i][j-1] == 1) continue;	
                // 대각선의 경우 위나 왼쪽은 벽이 아니어야함			
				dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                // 대각선, 대각선의 경우 이전 좌표에서 어느 것이었든 가능하다.
			}
		}
		
		for(int i = 0; i < 3; i++) {
			ans += dp[n - 1][n - 1][i]; 
            // 마지막 좌표의 모든 경우의 수 합
		}
		
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();

	}

}
