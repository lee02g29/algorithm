import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());	

		int[][] len = new int[n + 1][n + 1];
		int[] cnt = new int[n + 1];
    // 각 물건별 다른 물건까지 최단거리
    // 각 물건 별 비교결과 측정 안되는 물건들
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j)	len[i][j] = 0;
				else len[i][j] = 100_000_000;
			}
		} // 길이 배열을 미리 초기화하기
    // 같은 곳 방문은 체크 x
    // 그 외엔 적당히 큰 값으로 초기화
		
		for(int i = 0; i < m; i++) {
			String[] str = bf.readLine().split(" ");
			
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);	
			
			len[a][b] = 1;
		} // 단방향 그래프

		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					len[i][j] = Math.min(len[i][j], len[i][k] + len[k][j]);
				}
			}
		} // 플루이드 워셜
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) continue; // 같은곳은 x
				
				if(len[i][j] == 100_000_000 
           && len[j][i] == 100_000_000) cnt[i]++;
        // i -> j, j -> i도 방문이 불가능해야 비교 결과를 알 수가 없음
        // 방문 불가능 = 거리가 초기 값에서 안바뀜
			}
		}
		
		for(int i = 1; i <= n; i++) {
			bw.write(cnt[i] + "\n");
		} // 그리고 각 물건별로 출력해주기
		
		bw.flush();
		bw.close();
	}

}
