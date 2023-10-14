import java.util.*;
import java.io.*;

class Main {
	
	public static int n, m;
	public static String[][] map; 
	public static boolean[][] visit; 
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
  // 사방 탐색

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
    // 가로 세로
		
		map = new String[m][n];
		visit = new boolean[m][n];
		
		int score1 = 0;
		int score2 = 0;
		// 아군 적군의 점수
        
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split("");
			
			for(int j = 0; j < n; j++) {
				map[i][j] = str[j];
			}
		} // 맵
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j]) { // 방문한적 없으면 
					int temp = bfs(i, j); 
          // bfs로 인접 인원 수 측정
					
					if(map[i][j].equals("W")) { // 아군
						score1 += temp * temp;
					} else { // 적군
						score2 += temp * temp;
					}
          // 아군 적군 별로 위력 측정
				}
			}
		}
		
		bw.write(score1 + " " + score2 + "\n");
   // 아군 적군 순으로 위력 출력

		bw.flush();
		bw.close();
	}

	public static int bfs(int x, int y) {
    // bfs
		Queue<Pair> queue = new LinkedList<>();
		
		queue.offer(new Pair(x, y));
		visit[x][y] = true;
		// 초기 좌표부터 시작
		int cnt = 1;
    // 인원수는 초기 좌표의 인원을 포함함
		
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
        // 사방 탐색
				
				if(check(nx, ny)) continue;
        // 맵 바깥 x
				if(visit[nx][ny]) continue;
        // 방문한 거 x
				if(!map[cur.x][cur.y].equals(map[nx][ny])) continue;
        // 다른 진영 x
				
				cnt++; // 인원수 증가
				queue.offer(new Pair(nx, ny));
				visit[nx][ny] = true;
        // 다음 좌표 방문 & 처리
				
			}
		}
		
		return cnt;
	}
	
	public static boolean check(int x, int y) {
		return x < 0 || x >= m || y < 0 || y >= n;
	} // 맵 바깥이면 true, 아니면 false를 반환
    
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
