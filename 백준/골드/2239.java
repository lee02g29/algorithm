import java.io.*;
import java.util.*;

public class Main {
	static int[][] sudoku;
	static boolean[][][] check;
	static ArrayList<Pair> arr;
	static boolean complete = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sudoku = new int[9][9]; // 스도쿠 판
		check = new boolean[3][9][10]; 
        // 가로, 세로, 9칸 별 숫자 존재 여부
		arr = new ArrayList<>();
        // 0인 부분만 좌표 저장

		for (int i = 0; i < 9; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < 9; j++) {
				int nums = Integer.parseInt(str[j]);
				sudoku[i][j] = nums;
                // 스도쿠 맵 저장

				if (nums != 0) { // 숫자가 존재하면
					check[0][i][nums] = true;
					check[1][j][nums] = true;
					check[2][part(i, j)][nums] = true;
                    // 존재 여부 체크
                    // 9칸은 아래에서 서술
				} else { // 숫자가 0이면 따로 저장
					arr.add(new Pair(i, j));
				}
			}
		}

		play(0);
        // 0번째 칸부터 체크
        // 여기부터 체크해야 숫자가 작은 순서대로 들어가서
        // 문제의 조건 달성 가능

		bw.flush();
		bw.close();

	}

	public static void play(int idx) {
		if (idx == arr.size()) {
            // 모든 0을 보았음 = 스도쿠 완성
			complete = true;
            // 플래그 처리

			for (int i = 0; i < 9; i++) {

				for (int j = 0; j < 9; j++) {

					System.out.print(sudoku[i][j] + "");

				}
				System.out.println();
			} // 답 출력하기

			return;
		}
		
		int x = arr.get(idx).x;
		int y = arr.get(idx).y;
        // 이번 스도쿠 위치

		for (int i = 1; i <= 9; i++) {
            // 들어갈 숫자는 1~9까지 작은 순서대로

			if (vaild(x, y, i)) {
                // 이번 좌표에 이번 숫자는 들어갈 수 있을까?
                // 들어가면 밑에 코드 실행
				sudoku[x][y] = i;
				check[0][x][i] = true;
				check[1][y][i] = true;
				check[2][part(x, y)][i] = true;
                // 숫자를 넣어보고
                // 숫자 존재여부 체크

				play(idx + 1);
                // 다음 좌표 시작
				if (complete)
					return;
                // 백트래킹이 아니라, 완성 된채로 돌아왔으면
                // 종료
				sudoku[x][y] = 0;
				check[0][x][i] = false;
				check[1][y][i] = false;
				check[2][part(x, y)][i] = false;
                // 숫자 및 존재여부 반환
			}
		}

	}

	public static int part(int x, int y) {
		int row = x / 3;
		int col = y / 3;
		return row * 3 + col;
	} // 9칸 체크
    // 0 1 2 
    // 3 4 5
    // 6 7 8

	public static boolean vaild(int x, int y, int num) {
		if (check[0][x][num] || check[1][y][num] || check[2][part(x, y)][num])
			return false;
		return true;
	}
    // 이번 위치에 숫자를 놓을 수 있는지 확인
    // 이미 있으면 x

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // 좌표 저장용 클래스

}
