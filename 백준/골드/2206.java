import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int h = Integer.parseInt(str[0]); // 높이
		int w = Integer.parseInt(str[1]); // 너비

		int[][] nums = new int[h + 1][w + 1];
		boolean[][] visit = new boolean[h + 1][w + 1]; // 방문 여부
		Queue<Pair> queue = new LinkedList<>(); // 큐

		int[][] route_A = new int[h + 1][w + 1]; // 시작점부터의 거리
		int[][] route_B = new int[h + 1][w + 1]; // 도착점부터의 거리
		
		int ans = Integer.MAX_VALUE;

		for (int i = 1; i <= h; i++) {
			str = bf.readLine().split("");

			for (int j = 1; j <= w; j++) {
				nums[i][j] = Integer.parseInt(str[j - 1]);
			}
		} // 입력받기

		queue.add(new Pair(1, 1));
		visit[1][1] = true;
    // 시작점부터 알아보기

		while (!queue.isEmpty()) { // BFS
			int len = queue.size();

			while (len-- > 0) {
				int x = queue.peek().x;
				int y = queue.peek().y;

				queue.remove();

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx <= 0 || nx > h || ny <= 0 || ny > w || visit[nx][ny] == true)
						continue;

					if (nums[nx][ny] == 1) { 
            // 0인 지점에서 1인 지점을 가는 경우 = 벽을 부수는 경우
						route_A[nx][ny] = route_A[x][y] + 1;
						visit[nx][ny] = true;
						continue;
					} // 거리 체크하기, 다음 방문지로는 x

					queue.add(new Pair(nx, ny)); // 벽이 아닌 경우 
					visit[nx][ny] = true; // 방문 처리
					route_A[nx][ny] = route_A[x][y] + 1; // 다음 방문좌표는 현재 방문 거리 + 1

				}
			}
		}

		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				visit[i][j] = false;
			}
		}
    // 방문 초기화
		queue.clear(); // 큐 초기화
		
		queue.add(new Pair(h, w));
		visit[h][w] = true;
    // 도착점부터 알아보기

		while (!queue.isEmpty()) {
			int len = queue.size();

			while (len-- > 0) {
				int x = queue.peek().x;
				int y = queue.peek().y;

				queue.remove();

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx <= 0 || nx > h || ny <= 0 || ny > w || visit[nx][ny] == true)
						continue;

					if (nums[nx][ny] == 1) {
						route_B[nx][ny] = route_B[x][y] + 1;
						visit[nx][ny] = true;
						continue;
					}

					queue.add(new Pair(nx, ny));
					visit[nx][ny] = true;
					route_B[nx][ny] = route_B[x][y] + 1;

				}
			}
		}

		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				if (route_A[i][j] > 0 && route_B[i][j] > 0 && nums[i][j] == 1 && route_A[i][j] + route_B[i][j] < ans)
					ans = route_A[i][j] + route_B[i][j];
			}
		} // 시작점과 도착점에서 특정 좌표까지의 거리 중 최소 거리를 구하기
		
		if(route_A[h][w] != 0) ans = Math.min(ans, route_A[h][w]); 
    // 벽이 아예 없을 경우, 시작점부터의 거리 쓰기
		if(w * h == 1) ans = 0; // 좌표가 딱 하나일 때.
		if(ans == Integer.MAX_VALUE) { // 거리를 구할 수 없을 때
			bw.write(-1 + "\n");
		}
		else bw.write(ans + 1 + "\n");
		
		bw.flush();
		bw.close();
	}

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
