import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[][] shape_x = { { 0, 1, 2, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, -1 }, { 0, -1, 0, 1 } };
	static int[][] shape_y = { { 0, 0, 0, 1 }, { 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 0, 1, 1, 1 } };
  // ㅏ모양 탐색용
  // 순서는 ㅏ, ㅜ, ㅗ, ㅓ순서

	static boolean[][] check;
  // 좌표 방문 여부

	static int ans;
	static int n, m;
	static int[][] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
    // 배열 크기

		nums = new int[n + 2][m + 2];
		check = new boolean[n + 2][m + 2];

		for (int i = 1; i <= n; i++) {
			str = bf.readLine().split(" ");

			for (int j = 1; j <= m; j++) {
				nums[i][j] = Integer.parseInt(str[j - 1]);
			}
		} // 점수 입력용

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) { // 좌표 탐색
				check[i][j] = true; // 방문 했음

				dfs(i, j, nums[i][j], 1);
        // dfs 시작, ㅏ모양 제외

				check[i][j] = false; // 방문 반환

				shape(i, j); // ㅏ 모양 탐색 시작
			}
		}

		bw.write(ans + "\n");

		bw.flush();
		bw.close();

	}

	public static void dfs(int x, int y, int sum, int len) { 
    // ㅏ 모양을 제외한 나머지는 길이 4의 dfs모양임
    
		if (len >= 4) { // 길이 4를 넘지 않도록
			ans = Math.max(ans, sum); // 최대값 갱신
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 1 || nx > n || ny < 1 || ny > m)
				continue;
      // 배열 바깥

			if (check[nx][ny] == false) { // 방문하지 않았다면
				check[nx][ny] = true; // 방문 처리

				dfs(nx, ny, sum + nums[nx][ny], len + 1); // 다음 칸 방문

				check[nx][ny] = false; // 방문 반환
			}
		}
	}

	public static void shape(int x, int y) {
    // ㅏ모양 탐색

		for (int i = 0; i < 4; i++) { // 모양 순서
			boolean check = false;
			int sum = 0;

			for (int j = 0; j < 4; j++) { // 모양 좌표
				int nx = x + shape_x[i][j];
				int ny = y + shape_y[i][j];

				if (nx < 1 || nx > n || ny < 1 || ny > m) {
					check = true;
					break;
				} else { // 배열 바깥이 아니면
					sum += nums[nx][ny]; // 계산하기
				}

				if (!check) { // 배열 바깥으로 안갔다면
					ans = Math.max(ans, sum); // 최대값 갱신
				}
			}

		}
	}

}
