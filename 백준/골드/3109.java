import java.util.*;
import java.io.*;

class Main {
	static int[] dx = { -1, 0, 1 };

	static String[][] board;

	static int r, c;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);

		board = new String[r][c];

		ans = 0;

		for (int i = 0; i < r; i++) {
			str = bf.readLine().split("");

			for (int j = 0; j < c; j++) {
				board[i][j] = str[j];
			}
		} // 맵 입력

		for (int i = 0; i < r; i++) {
			dfs(i, 0); // 시작지점은 무조건 1열
      // 시작지점부터 dfs
		}

		bw.write(ans + "\n"); // 출력

		bw.flush();
		bw.close();

	}

	public static boolean dfs(int x, int y) {

		if (y == c - 1) { 
      // 도착지점은 언제나 마지막 열
      // 마지막열에 도착했다면 
			ans++; // 답 개수 증가
			return true; // 연결할 수 있음을 반환
		}

		for (int i = 0; i < 3; i++) { // 3방향 탐색
			int nx = x + dx[i];
			int ny = y + 1; // 무조건 오른쪽으로만 감

			if (check(nx, ny)) // 맵 바깥이면
				continue; // 체크 안함

			if (board[nx][ny].equals("x")) // 건물이면
				continue; // 못가므로 체크안함

			board[nx][ny] = "x"; // 지금 확인하는 곳 방문 처리

			if (dfs(nx, ny)) // 다음 좌표 탐색, 좌표 탐색 결과 true라면
				return true; // true 반환

		}

		return false; // 이외엔 마지막 열에 닿을 수 없음
	}

	public static boolean check(int x, int y) {
		return x < 0 || x >= r || y < 0 || y >= c; // 맵 바깥 확인

	}

}
