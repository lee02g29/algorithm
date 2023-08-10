import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] check;
	static int[][] nums;
	static int n;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	
	static int temp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt( bf.readLine() );
		
		for(int t = 1; t <= test; t++) {
			n = Integer.parseInt( bf.readLine() );
			nums = new int[n][n];
			check = new boolean[n][n];
			
			temp = 0; // 시작 방 번호
			max = 0; // 최대 길이
      // 초기값

			for(int i = 0; i < n; i++) {				
				String[] str = bf.readLine().split(" ");
				
				for(int j = 0; j < n ; j++) {
					nums[i][j] = Integer.parseInt( str[j] );
				}
			} // 숫자 입력
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {

					dfs(j, k, 1, nums[j][k]); // 좌표, 길이, 방 번호 순
					
				}
			}
			
			bw.write("#" + t + " " + temp + " " + max + "\n"); / 출력
			
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y, int len, int start) {
		check[x][y] = true; // 방문 처리
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) // 배열 바깥 처리
				continue;


			if (check[nx][ny] == false && nums[x][y] + 1 == nums[nx][ny]) { 
        // 방문한 적 없고, 다음 방 번호가 이번 방 번호 + 1이면
				dfs(nx, ny, len + 1, start); // 다음 방문

			}
			
		}
		
		if(len > max) {
			max = len;
			temp = start;
		} // 길이가 더 길면 갱신
		
		if(len == max) { // 길이가 같으면
			temp = Math.min(temp, start); // 방 번호가 더 작은거
		}
		
		check[x][y] = false; // 방문 반납

	}
}
