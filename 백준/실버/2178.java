import java.util.*;
import java.io.*;

class Main {

	static int n, m;
	static int[][] board;
	static int [][] visit;
	static Queue<Pair> queue;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		n = Integer.parseInt( str[0] );
		m = Integer.parseInt( str[1] );
		
		board = new int[n][m];
    // 미로
		visit = new int[n][m];
		// 방문여부
		queue = new LinkedList<>();
    // bfs용 큐
		
		for(int i = 0; i < n; i++) {
			str = bf.readLine().split("");
			
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(str[j]);
			}
		} // 미로 입력
		
		for(int i = 0; i < n; i++) {		
			for(int j = 0; j < m; j++) {
				visit[i][j] = -1;
			}
		} // 아직 방문하지 않았음

		queue.offer(new Pair(0, 0)); // 0, 0부터 시작하기
		visit[0][0] = 1; // 시작부터 1초
		
		bfs(0, 0);
		
		bw.write(visit[n-1][m-1] + "\n");
    // 도착위치의 시간 출력

		bw.flush();
		bw.close();

	}

	
	public static void bfs(int x, int y) {

		while(!queue.isEmpty()) {
			
			int tx = queue.peek().x;
			int ty = queue.peek().y;
      // 다음 위치 좌표
			
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				
				int nx = tx + dx[i];
				int ny = ty + dy[i];
        // 그 다음 위치 탐색
				
				if(check(nx, ny)) continue;
        // 판 밖이면 패스
				
				if(board[nx][ny] == 0) continue;
        // 못가는 곳이면 패스
				
				if(visit[nx][ny] != -1) continue;
        // -1이 아니면 방문한적 있으므로 = 최단이 아니므로 패스
				
				visit[nx][ny] = visit[tx][ty] + 1;
        // 이번 방문 시간은 이전 좌표의 방문 시간 + 1
				
				queue.offer(new Pair(nx, ny));
        // 다음 좌표
			}
			
		}
		
	}
	
	public static class Pair {
		int x;
		int y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean check(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= m;
	}
}
