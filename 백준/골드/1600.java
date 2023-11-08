import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static boolean[][][] visit;
	static int k, h, w;
	static int[][] next = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 일반 4방향
	static int[][] horse = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };
  // 말의 움직임

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		k = Integer.parseInt(bf.readLine());
		
		String[] str = bf.readLine().split(" ");
		
		w = Integer.parseInt(str[0]);
		h = Integer.parseInt(str[1]);
		
		map = new int[h][w]; // 맵
		visit = new boolean[h][w][k + 1];
    // 0~k번 움직였을 때 도착 여부
		
		for(int i = 0; i < h; i++) {
			str = bf.readLine().split(" ");
			
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} // 지도
		
		int ans = bfs(0, 0, k);
    // 0 0부터 시작하기
		bw.write(ans + "\n");

		bw.flush();
		bw.close();
	}

	public static int bfs(int x, int y, int k) {
    // bfs
		Queue<Pair> queue = new LinkedList<>();
		
		queue.offer(new Pair(x, y, 0, 0));
		visit[x][y][0] = true;
    // 시작위치와 시작 위치 방문 여부
    
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			
			if(cur.x == h-1 && cur.y == w - 1) {
				return cur.move;
			} // 도착지점에 무사히 왔다면 이동 횟수 반환
			
			for(int i = 0; i < 4; i++) {
        // 4방향 탐색
				int nx = cur.x + next[i][0];
				int ny = cur.y + next[i][1];
				
				if(check(nx, ny)) continue; // 맵바깥
				if(visit[nx][ny][cur.hjump]) continue; // 방문여부
				
				if(map[nx][ny] == 0) { 
          // 다음 목표지점이 갈 수 있는 지점
					visit[nx][ny][cur.hjump] = true;
					queue.offer(new Pair(nx, ny, cur.hjump, cur.move + 1));
          // 방문 처리 후 큐에 넣기
          // 네방향으로 움직이기만 했으므로 move + 1
				}
			}
			
			if(cur.hjump == k) continue;
      // 말의 움직임이 k번이면 패스
			
			if(cur.hjump < k) { // 말의 움직임이 k번 이하
				for(int i = 0; i < 8; i++) { // 움직이기
					int nx = cur.x + horse[i][0];
					int ny = cur.y + horse[i][1];
					
					if(check(nx, ny)) continue; // 맵 바깥
					if(visit[nx][ny][cur.hjump + 1]) continue;
          // 말의 움직임 + 1한 것 방문 여부 체크
					
					if(map[nx][ny] == 0) { // 다음 지점 갈 수 있음
						visit[nx][ny][cur.hjump + 1] = true;
						queue.offer(new Pair(nx, ny, cur.hjump + 1, cur.move + 1));
            // 방문 처리 후 큐에 넣기
            // 말의 움직임으로 행동했으므로, 말의 움직임 + 1도 해주기
					}
				}
			}
		}
		
		return -1;
    // 다 했는데도 도착지점 못감
	}
	
	public static boolean check(int x, int y) {
		return x < 0 || x >= h || y < 0 || y >= w;
	} // 맵 바깥체크
	
	public static class Pair {
		int x;
		int y;
		int hjump;
		int move;
		
		public Pair(int x, int y, int hjump, int move) {
			super();
			this.x = x;
			this.y = y;
			this.hjump = hjump;
			this.move = move;
		}
		
		
	}
}
