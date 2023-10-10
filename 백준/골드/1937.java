import java.io.*;
import java.util.*;

// 대나무가 많은 칸부터 역으로 이동할 수 있는 곳을 찾기
// 이동 칸수를 세기
// = 단말부터 세기

public class Main {

	static int num;
	static int[][] map;
	static int[][] dp;
	static PriorityQueue<Pair> queue;
	static int ans;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
  // 네 방향 남색

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		num = Integer.parseInt(bf.readLine());

		map = new int[num][num]; // 맵
		dp = new int[num][num]; // 이동 칸수
		queue = new PriorityQueue<>(); // 대나무 내림차순

		for (int i = 0; i < num; i++) {
			String[] str = bf.readLine().split(" ");
			for (int j = 0; j < num; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} // 맵 

		ans = -1; // 가장 긴 이동칸수 = 답

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				queue.offer(new Pair(j, i, map[i][j]));
			}
		} // 좌표와 대나무를 큐에 넣기

		bfs(); // 탐색 시작

		bw.write(ans + "\n");

		bw.flush();
		bw.close();

	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
      // 이번 위치

			int max_temp = 0; 이번 위치에서의 최대 길이

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
        // 다음 위치
				if (check(nx, ny)) // 맵 바깥 x
					continue;

				if (map[ny][nx] < cur.tree && dp[ny][nx] > max_temp) {
					max_temp = dp[ny][nx];
				} // 다음 위치의 대나무 수가 더 적고
        // 이동 칸수가 더 크다면 갱신
			}

			dp[cur.y][cur.x] = max_temp + 1;
      // 이번 위치의 이동 칸 수 + 1

			if (ans < dp[cur.y][cur.x])
				ans = dp[cur.y][cur.x];
      // 이번 위치의 이동 칸수가 저장된 답보다 크면 갱신
		}
	}

	public static boolean check(int x, int y) {
		return x < 0 || x >= num || y < 0 || y >= num;
	}

	public static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int tree;

		public Pair(int x, int y, int tree) {
			super();
			this.x = x;
			this.y = y;
			this.tree = tree;
		}

		@Override
		public int compareTo(Pair o) {
			return this.tree - o.tree;
		}

	}
}
