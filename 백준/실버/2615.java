import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int[][] board = new int[21][21];
	static int[] dx = { 0, 1, -1, 1 };
	static int[] dy = { 1, 1, 1, 0 };
  // 방향은 왼쪽과 위로 가지 않으므로, 해당 방향은 제거함
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		boolean win1 = false; // 1이 이겼는지 여부
		boolean win2 = false; // 2가 이겼는지 여부

		int check1 = 0;
		int check2 = 0;
    // 이긴 사람의 좌표 저장용

		for (int i = 1; i <= 19; i++) {
			String[] str = bf.readLine().split(" ");

			for (int j = 1; j <= 19; j++) {
				board[i][j] = Integer.parseInt(str[j - 1]);
			}
		} // 문제의 조건대로 1부터 시작하기 위해서 배열의 1~19사용

		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				boolean flags = false; // 오목이 완성됐는지 여부
				
				if (board[i][j] == 1) { // 1번 사람 탐색

					for (int k = 0; k < 4; k++) { // 방향 탐색
						cnt = 1;
						
						if(board[i - dx[k]][j - dy[k]] == 1) continue; 
            // 해당 방향의 반대방향에 1이 있다면 이미 탐색한 방향임
						flags = check(i, j, 1, k); // 그 외엔 같은 방향의 오목 탐색

						if (flags) { // 오목이라면
							win1 = true;
							check1 = i;
							check2 = j;
						} 
					}

				}

				else if (board[i][j] == 2) { // 2번 탐색

          // 1번사람과 동일함
					for (int k = 0; k < 4; k++) {
						cnt = 1;
						
						if(board[i - dx[k]][j - dy[k]] == 2) continue;
						flags = check(i, j, 2, k);

						if (flags) {
							win2 = true;
							check1 = i;
							check2 = j;
						}
					}

				}
        
			}
      
		}

		if (win1 == false && win2 == false) { // 둘 다 못이김
			System.out.println(0);
		} else if (win1 == true) { // 1번 사람 이김
			System.out.println(1);
			System.out.println(check1 + " " + check2);
		} else if (win2 == true) { // 2번 사람 이김
			System.out.println(2);
			System.out.println(check1 + " " + check2);
		}

	}

	public static boolean check(int i, int j, int type, int dir) { // 한 방향의 오목 탐색 함수

		if (cnt >= 6) // 돌이 6개 이상이라면 오목이 아님
			return false;

		if (i < 1 || i > 19 || j < 1 || j > 19) // 판의 테두리를 벗어나면 오목 아님
			return false; 

		boolean flag = false; // 오목 여부
		int nx = i + dx[dir];
		int ny = j + dy[dir];		
    // 다음 방향

		if (board[nx][ny] == type) { // 다음 방향의 숫자와 이번 숫자가 같다면
			cnt++; // 개수 증가
			flag = check(nx, ny, type, dir); // 다음 탐색 - 재귀
			return flag; // 재귀 결과를 그대로 반환함
		} else if (board[nx][ny] != type && cnt < 5) { 
      // 같은 숫자가 아니고 개수가 5보다 작으면 오목이 아님
			return false;
		} else { // 나머지는 오목임 = 같은 숫자가 아님 + 5개이면 오목임
      // 5개 초과는 위에서 걸러냄
			return true;
		}

	}

}
