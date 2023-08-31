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
    // dp용 배열, [도시][비스마스크 종류의 개수]
		
		for(int i = 0; i < n; i++) {
			String[] str = bf.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt( str[j] );
			}
		} // 도시 입력받기
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1); 
      // -1로 초기화. 방문하지 않았음을 의미함
		}

		bw.write(dfs(0 , 1) + "\n"); 
    // 시작지점은 아무거나 편의상 0으로하기
		
		bw.flush();
		bw.close();

	}
	
	public static int dfs(int cur, int bit) {
		
		if(bit == (1 << n) - 1) { // 모두 방문했을 때,
			if(map[cur][0] == 0) return 1_000_000_000;
      // 현재 도시에서 처음으로 가는 거리가 없음 = INF(1e9)를 반환
			return map[cur][0];
      // 그 외엔 거리 반환하기
		}
		
		if(dp[cur][bit] != -1) { // 방문한적이 있음
			return dp[cur][bit]; // 그 값 반환
		}
		
		dp[cur][bit] = 1_000_000_000; 
    // 방문한적 있다고 하기. 거리는 INF로 초기화
		
		for(int i = 0; i < n; i++) {
			if((bit & (1 << i)) == 0 && map[cur][i] != 0) { // 방문한적 없음, 가지 못하는 것도 아님
				dp[cur][bit] = Math.min( dp[cur][bit], dfs(i, bit | (1 << i) )  + map[cur][i]);
        // 최소값은 (현재 있는 값, 다음 방문 값 + 도시 이동비용) 중 최소값을 가져오기
			}
		}
		
		return dp[cur][bit]; // 위에서 걸리지 않는다면, dp값 반환
	}

}
