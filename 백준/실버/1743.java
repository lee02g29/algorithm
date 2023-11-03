import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
  // 4방향 배열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
    // 세로 길이, 가로 길이, 쓰레기의 개수

		map = new int[n][m];
		visit = new boolean[n][m];
    // 지도와 좌표 방문 여부

		for (int i = 0; i < k; i++) {
			str = bf.readLine().split(" ");

			int a = Integer.parseInt(str[0]) - 1;
			int b = Integer.parseInt(str[1]) - 1;

			map[a][b] = 1;
		} // 쓰레기 위치를 맵에 저장하기
		
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
          // 쓰레기가 있고, 방문한적 없으면
					max = Math.max(max, bfs(i, j));
          // bfs를 하고, 인접한 쓰레기의 개수를 반환받음
          // 더 큰 값으로 갱신
				}
			}
		}
		
		bw.write(max + "\n");

		bw.flush();
		bw.close();
	}

	public static int bfs(int x, int y) {
    // bfs
		Queue<Pair> queue = new LinkedList<>();

		queue.offer(new Pair(x, y));
		visit[x][y] = true;
    // 처음 좌표 큐에 넣기, 방문 처리하기
		int cnt = 1;

    // bfs
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
        // 다음 좌표
        
				if(check(nx, ny)) continue;
        // 맵 바깥 패스
				
				if (visit[nx][ny])
					continue;
        // 이미 방문한 곳 패스
				if(map[nx][ny] != 1) continue;
        // 빈칸 패스

				queue.offer(new Pair(nx, ny));
				visit[nx][ny] = true;
				cnt++;
        // 큐에 넣고 방문처리하고
        // 인접 쓰레기 개수 증가
			}
		}
		
		return cnt;
    // 인접 쓰레기 개수 반환

	}
	
	public static boolean check(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= m;
	} // 맵 바깥 체크용

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
