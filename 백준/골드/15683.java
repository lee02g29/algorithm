import java.io.*;
import java.util.*;

public class Solved {

	static int n, m;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
  // 방향
	static int[][] map; 
  // cctv 지도
	static int[][] visit;
  // cctv가 볼 수 있는 곳
	static ArrayList<Pair> order;
  // cctv 위치 리스트
	static int room;
  // 최소 방

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		map = new int[n][m];
		visit = new int[n][m];
		order = new ArrayList<Pair>();
		room = (n + 1) * (m + 1);
    // 최대치는 크기보다 크게

		for (int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} // cctv 지도

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (map[i][j] != 0 && map[i][j] != 6) { 
          // 빈 공간이거나 벽이 아니라면
          // = cctv라면
					order.add(new Pair(i, j)); // 좌표를 저장하기
					visit[i][j] = (n + 1) * (m + 1);
          // 값을 주기
				} else if (map[i][j] == 6) // 벽이면
					visit[i][j] = (n + 1) * (m + 1);
        // 좌표 저장은 안하고 값을 주기
        // = 나중에 0값을 사각지대로 줄 것이 때문
			}
		}

		cctv(0); // 첫번째 cctv부터 시작하기

		bw.write(room + "\n");

		bw.flush();
		bw.close();

	}

	public static void cctv(int cur) {
		if (cur == order.size()) { 
      // 마지막 cctv까지 배치가 끝났다
			int temp = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit[i][j] == 0) { 
            // 한번도 닿지 않은 공간이면 
            // 사각지대이므로
						temp++; // 체크
					}
				}
			}

			room = Math.min(room, temp);
      // 기존 값과 이번 값 비교하여 최소값 채용

			return;
		}

		Pair p = order.get(cur);
    // 이번 cctv 

		int x = p.x;
		int y = p.y;
    // cctv 배치
    
		int type = map[x][y];
    // 이번 cctv의 종류

		if (type == 1) { // 1번이라면
			for (int d = 0; d < 4; d++) {
        // 한쪽 방향만 볼 수 있으므로 반복문
				dfs(x, y, d, true); // 한방향을 골라서 +1해주기

				cctv(cur + 1); // 다음 cctv 배치

				dfs(x, y, d, false); // 백트래킹, 이번 방향 -1해주기
			}
		}

		else if (type == 2) { // 2번이라면
			for (int d = 0; d < 2; d++) { // 상하, 좌우로 끝
				dfs(x, y, d, true); 
				dfs(x, y, (d + 2), true);
        // 방향 배열을 설정한 순서에 따라 다름
        // 이 코드에서는 우 하 좌 상 순서
        // 수평 방향은 2칸씩 차이나므로 + 2
				cctv(cur + 1);

				dfs(x, y, d, false);
				dfs(x, y, (d + 2), false);
        // 배치 반환
			}
		}

		else if (type == 3) { // 3이라면
			for (int d = 0; d < 4; d++) { 
        // 귀찮으니까 4방향 다돌림
				dfs(x, y, d, true);
				dfs(x, y, (d + 1) % 4, true);
        // 이 코드에서 수직방향은 한칸씩 차이남
				cctv(cur + 1);

				dfs(x, y, d, false);
				dfs(x, y, (d + 1) % 4, false);
        // 배치 반환
			}
		}

		else if (type == 4) { // 4라면
			dfs(x, y, 0, true);
			dfs(x, y, 1, true);
			dfs(x, y, 2, true);
			dfs(x, y, 3, true);
      // 4방향 일단 다 처리해버리기

			for (int d = 0; d < 4; d++) {
				dfs(x, y, d, false);
        // 한 방향을 골라서 지워버리기
				cctv(cur + 1);
				dfs(x, y, d, true);
        // 지운거 다시 돌려놓기

			}

			dfs(x, y, 0, false);
			dfs(x, y, 1, false);
			dfs(x, y, 2, false);
			dfs(x, y, 3, false);
      // 배치 반환
		}

		else if (type == 5) { // 5라면

			dfs(x, y, 0, true);
			dfs(x, y, 1, true);
			dfs(x, y, 2, true);
			dfs(x, y, 3, true);
      // 4방향 다하기
			cctv(cur + 1);

			dfs(x, y, 0, false);
			dfs(x, y, 1, false);
			dfs(x, y, 2, false);
			dfs(x, y, 3, false);
      // 배치 반환
		}
	}


	public static void dfs(int x, int y, int d, boolean check) {
		int nx = x;
		int ny = y;

		while (true) {
			nx += dx[d];
			ny += dy[d];
      // 해당 방향으로 나아가기
			if (check(nx, ny)) // 맵 밖 x
				break;

			if (map[nx][ny] == 6) // 벽 x
				break;

			if (check) // 이번 호출은 cctv를 배치하는 경우
				visit[nx][ny]++; // 그 좌표는 봤음을 체크
			else { // 이번 호출은 배치를 반환하는 경우
				if (visit[nx][ny] > 0) // 본 경우에만 반환
					visit[nx][ny]--;
			}
		}

	}

	public static boolean check(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= m;
	} // 맵 바깥 체크

	public static class Pair { // 좌표 클래스
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
