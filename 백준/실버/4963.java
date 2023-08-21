import java.io.*;
import java.util.*;

public class Solved {
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
  // 8방향
	
	static int[][] map;
	static int h, w;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String temp = null;

		while ((temp = bf.readLine()) != null) { 
			String[] str = temp.split(" ");			
			
			if(str[0].equals("0") && str[1].equals("0")) break; 
      // 입력 끝이면 정말 끝내서 이 뒤로 실행 안하기
			
			w = Integer.parseInt(str[0]);
			h = Integer.parseInt(str[1]);
      // 높이 너비
			
			if(w * h == 1) {
				int temps = Integer.parseInt( bf.readLine() );
				
				if(temps == 1) bw.write(1 + "\n");
				else bw.write(0 + "\n");
				
				continue;
			} // 맵 크기가 1이면 입력된 종류에 따라 답 출력하고 다음으로 넘어가기
      // 그냥 처리하면 낭비일?듯
			
			map = new int[h][w]; // 지도
			int cnt = 0; // 섬 개수
			
			for(int i = 0; i < h; i++) {
				str = bf.readLine().split(" ");	
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			} // 지도 입력받기
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1) { // 섬일 때 탐색 시작
						dfs(i, j); // dfs
						cnt++; // 섬 개수 추가
					}
				}
			}

			bw.write(cnt + "\n"); // 섬 개수 출력
			
		}

		bw.flush();
		bw.close();

	}
	
	public static void dfs(int x, int y) {
		map[x][y] = 2; // 0도 1도 아닌 값을 주어 혹시나 하는 일 방지하기
		
		for(int i = 0; i < 8; i++) { // 8방향 탐색하기
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(check(nx, ny)) continue; // 지도 바깥이면 넘어가기
			
			if(map[nx][ny] != 1) continue; // 섬이 아니면 넘어가기
			
			dfs(nx, ny); // 다음 좌표 탐색

		}
	}

	public static boolean check(int x, int y) { // 지도 바깥 탐색 함수
		return x < 0 || y < 0 || x >= h || y >= w;
	}
}
