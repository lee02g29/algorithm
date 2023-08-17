import java.util.*;
import java.io.*;

class Main {

	static int[][] board;
	static int[][] dir;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int r, c;
	static int ans;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		r = Integer.parseInt(str[0]); // 세로
		c = Integer.parseInt(str[1]); // 가로

		board = new int[r][c]; // 치즈 지도
		dir = new int[r][c]; // 치즈가 녹는 시점 배열
		PriorityQueue<Pair> queue = new PriorityQueue<>();
    // 큐

		ans = 0; // 치즈가 다 녹기 1초전 남은 치즈 개수
		max = Integer.MIN_VALUE; // 치즈가 다 녹는데 걸리는 시간

		for (int i = 0; i < r; i++) {
			str = bf.readLine().split(" ");

			for (int j = 0; j < c; j++) {
				board[i][j] = Integer.parseInt(str[j]);
				dir[i][j] = 1_000_000_000; // 치즈 디폴트 상태

			}
		}	// 입력받기

		queue.add(new Pair(0, 0, 0)); // 0, 0부터 탐색. 
		dir[0][0] = 0; 

		while (!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
      // 좌표
			int dis = queue.peek().l;
      // 해당 좌표의 치즈가 녹는 시점
      
			queue.remove();
			if (dir[x][y] != dis) 
        // 배열에 저장된 시간과 큐에 저장된 값이 다르면
        // 이전에 이미 접촉된적 있으면
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
        // 다음 좌표

				if (check(nx, ny)) // 맵 밖이면
					continue; // 패스

				int ndis = dis + board[nx][ny];
        // 다음 좌표의 녹는 시간 계산
        // 이전 치즈의 녹는 시간 + (0 / 1)

				if (ndis >= dir[nx][ny])
          // 이전에 이미 접촉한 적 있음
					continue;

				dir[nx][ny] = ndis; // 치즈가 녹는 시점 저장
				queue.add(new Pair(ndis, nx, ny)); // 다음 좌표 저장
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (max < dir[i][j]) 
          // 제일 숫자가 큰 것을 탐색
          // 제일 마지막에 녹는 치즈 탐색
					max = dir[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (dir[i][j] == max && board[i][j] == 1)
          // 마지막에 녹는 치즈 개수 세기
					ans++;
			}
		}

		bw.write(max + "\n" + ans + "\n");

		bw.flush();
		bw.close();

	}

	public static boolean check(int x, int y) {
		return x < 0 || x >= r || y < 0 || y >= c;
	}

	public static class Pair implements Comparable<Pair> {
		int l;
		int x;
		int y;

		Pair(int l, int x, int y) {
			this.l = l;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.l == o.l) {
				return this.x - o.x;
			} else if (this.x == o.x) {
				return this.y - o.y;
			} else
				return this.l - o.l;
		}
	}

}
