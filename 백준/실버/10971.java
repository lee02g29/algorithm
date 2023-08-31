import java.io.*;
import java.util.Arrays;


public class Main {
	static int n;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		n = Integer.parseInt( bf.readLine() );
		
		map = new int[n][n];
		dp = new int[n][(1 << n) - 1];
		
		for(int i = 0; i < n; i++) {
			String[] str = bf.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt( str[j] );
			}
		}
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 1_000_000_000); // 미리 1e9로 초기화하기
		}

		bw.write(dfs(0 , 1) + "\n"); // 시작점 아무거나 잡기
		
		bw.flush();
		bw.close();

	}
	
	public static int dfs(int cur, int bit) {
        // cur 현재 방문지점, bit 방문 여부를 비트마스크로 저장
		
		if(bit == (1 << n) - 1) { // 전부 방문했다면 = 모든 비트가 1인경우
			if(map[cur][0] == 0) return 1_000_000_000; 
            // 마지막 방문지에서 첫번째 지점 거리가 0이면 순회 x
            // 최대거리를 반환
			return map[cur][0];
            // 그 외엔 가능하므로 거리를 반환
		}
		
		if(dp[cur][bit] != 1_000_000_000) { // 최대거리가 아니면 이미 방문한 것
			return dp[cur][bit]; // 거리를 반환
		}
		
		for(int i = 0; i < n; i++) { // 시작지점부터 다음 도시 방문
			if((bit & (1 << i)) == 0 && map[cur][i] != 0) {
                // i번째 비트가 0이고(방문 안함), cur-i 간 거리가 0이 아님(갈 수 있음)
				dp[cur][bit] = Math.min( dp[cur][bit], dfs(i, bit | (1 << i) )  + map[cur][i]);
                // 거리는 저장된 거리와 다음 도시 방문 거리 + (현재 - 다음 도시 거리)중 최소 값을 채용
			}
		}
		
		return dp[cur][bit]; // 그 외엔 현재 도시의 값을 반환
	}

}
