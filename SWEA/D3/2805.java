import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(bf.readLine());

			String str;
			int[][] land = new int[n][n];
			int sum = 0;

			for (int i = 0; i < n; i++) {
				str = bf.readLine();
				for (int j = 0; j < n; j++) {
					land[i][j] = str.charAt(j) - '0';
				}
			} // 농작물 가치 저장

			int len = 1; // 이번 줄에서 탐색해야할 칸의 수

			for (int i = 0; i < n; i++) {

				for (int j = (n - len) / 2; j < (n - len) / 2 + len; j++) { 
          			// 이번 줄의 시작점 : 총 열의 개수에서 탐색칸의 수 빼고 2를 나눈다.
          			// 그리고 len만큼 탐색한다
					sum += land[i][j];
				}

				if (i >= (n - 1) / 2) // 중간을 넘었다면 탐색칸이 줄어든다
					len = len - 2;
				else // 그 외엔 탐색칸이 증가한다
					len = len + 2;

			}

			bw.write("#" + test_case + " " + sum + "\n"); // 출력
		}

		bw.flush();
		bw.close();
	}
}
