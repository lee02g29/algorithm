import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int n;
	static int l;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		l = Integer.parseInt(str[1]);
    // 맵 크기 n, 연속된 칸 l

		map = new int[n][n]; // 맵
		int cnt = 0; // 지나갈 수 있는 길의 개수

		for (int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} // 맵 입력

		for (int i = 0; i < n; i++) {
			if (findRow(i))
				cnt++;
			if (findCol(i))
				cnt++;
		} // 열과 행을 탐색 후 가능하면 길의 수 +1
		
		bw.write(cnt + "\n");
    // 길의 수를 출력

		bw.flush();
		bw.close();
	}

	public static boolean findRow(int row) {

		boolean[] cline = new boolean[n];
    // 경사로가 놓인 곳

		for (int i = 0; i < n - 1; i++) {
			int gap = map[row][i] - map[row][i + 1];
      // 다음 칸과의 높이 차이
			if (gap > 1 || gap < -1)
				return false;
        // 높이 차이가 1을 넘어가면 놓을 수 없음

			else if (gap == 1) { // 아래로 내려가는 경사
				for (int j = 1; j <= l; j++) { 
          // 현재 칸을 제외하고 +l칸까지 연속인지 확인
					if (i + j >= n || cline[i + j])
						return false; 
          // 확인 중에 맵 바깥으로 나가거나
          // 경사로가 놓여있으면 x
					if (map[row][i] - 1!= map[row][i + j])
            // 현재 칸이 1칸 높으므로, -1을 해서 비교하기
            // l칸 연속되지 않으면 x
						return false;
					cline[i + j] = true;
          // 위의 조건에서 걸리지 않았다면
          // 경사로 놓기
				}

			} else if (gap == -1) { // 위로 올라가는 경사
				for (int j = 0; j < l; j++) {
          // 현재 칸부터 -l칸 까지 연속인지 확인
					if (i - j < 0 || cline[i - j])
						return false;
					if (map[row][i] != map[row][i - j])
            // 현재 칸이 아래쪽 칸이므로, 
            // 현재 칸의 높이를 기준으로 비교
						return false;
					cline[i - j] = true;
				}
			}
		}
		return true;
	}

	public static boolean findCol(int col) {
  // 위와 동일함
  // 차이는 행인지 열인지의 차이
		boolean[] cline = new boolean[n];

		for (int i = 0; i < n - 1; i++) {
			int gap = map[i][col] - map[i + 1][col];

			if (gap > 1 || gap < -1)
				return false;

			if (gap == 1) {
				for (int j = 1; j <= l; j++) {
					if (i + j >= n || cline[i + j])
						return false;
					if (map[i][col] - 1!= map[i + j][col])
						return false;
					cline[i + j] = true;
				}

			} else if (gap == -1) {
				for (int j = 0; j < l; j++) {
					if (i - j < 0 || cline[i - j])
						return false;
					if (map[i][col] != map[i - j][col])
						return false;
					cline[i - j] = true;
				}
			}
		}
		return true;
	}

}
