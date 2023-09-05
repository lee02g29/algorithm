import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] dp; // dp배열, [ n번째 친구 ][얼리어답터 여부]
	static boolean[] visit; // 방문 여부
	static ArrayList<ArrayList<Integer>> arr; // 친구 관계
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine()); // 친구관계 정점 수
		
		arr = new ArrayList<>();
		dp = new int[n + 1][2];
		visit = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}

		for(int i = 0; i < n - 1; i++) {
			String[] str = bf.readLine().split(" ");
			
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			
			arr.get(s).add(e);
			arr.get(e).add(s);
		} // 친구관계 등록, 양방향임
		
		dp(1); // 아무 사람부터 시작하기
		bw.write(Math.min(dp[1][0], dp[1][1]) + "\n");
		
		bw.flush();
		bw.close();

	}
	
	public static void dp(int cur) { // 탑다운 dp
		visit[cur] = true; // 이번 친구 방문 처리
		dp[cur][0] = 0; // 이번 친구가 얼리어답터가 아니라면 경우의 수 x
		dp[cur][1] = 1; // 이번 친구가 얼리어답터라면 +1
		
		for(int next : arr.get(cur)) { // 연결된 친구들 탐색
			if(!visit[next]) {		// 방문했다면 패스
				dp(next); // 계산 전, 가장 마지막 친구까지 재귀를 해서 시작함
				dp[cur][0] += dp[next][1]; 
        // 이번 친구가 얼리어댑터가 아닌 경우, 이전의 친구는 얼리어댑터여야 함
				dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        // 이번 친구가 얼리어댑터면 어느쪽이든 상관 없으므로, 최소치를 찾기
			}
		}
	}
	
}
