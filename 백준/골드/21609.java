import java.util.*;
import java.io.*;

class Main {
	public static int[][] map;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
  // bfs
	public static boolean[][] visit;
  // 방문
	public static int n, m;
  // 맵 사이즈와 색 개수 (색은 전역으로 안썼음)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
    // 맵 크기와 색 개수

		map = new int[n][n];
    // 맵
		int sum = 0;
    // 점수 합
    
		for (int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} // 맵 입력

		while (true) { // 끝날때까지 반복
			Block next = findGroup();
      // 가장 큰 그룹 찾기
			if (next == null) 
        // 다음 그룹이 없을 때 종료
				break;

			sum += next.sum * next.sum;
      // 점수는 블럭의 개수^2
			
			removeBlock(next);
			// 해당 그룹의 블럭 제거
			gravity();
			// 중력 작용
			rotate();
			// 회전
			gravity();
      // 중력 작용
		}
		
		bw.write(sum + "\n");
    // 점수 출력
		bw.flush();
		bw.close();
	}

	public static Block findGroup() {
    // 블럭 찾기
		visit = new boolean[n][n];

		Block max = new Block(0, 0, -99, Integer.MIN_VALUE, Integer.MIN_VALUE);
    // 비교용 블럭 클래스

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
        // 맵 탐색
				if (map[i][j] == -1) {
					continue;
				} // 검은 블록 패스

				if (map[i][j] == 0) {
					continue;
				} // 무지개 블럭 패스

				if (map[i][j] == -99) {
					continue;
				} // 빈칸 패스

				if(visit[i][j]) {
					continue;
				} // 이미 방문한거 패스

				rainbowInitial(); 
        // 블럭 그룹 지정 전에, 
        // 무지개 방문 초기화
        // 다른 블럭에서도 쓸 수 있기때문

				Block cur = bfs(i, j);
        // 블럭 그룹 탐색

				if (cur == null) {
					continue;
				} // 그룹 없으면 패스

				if (max.compares(cur)) {
					max = cur;
				} // 문제의 조건대로 비교
        // 개수, 무지개, 행, 열 순
        // 자세한 내용 밑 참고

			}
		}

		if (max.color == -99) {
			return null;
		} // 비교용 블럭 객체의 내용이 바뀌지 않았다
    // = 블륵 그룹 못 찾음
		
		return max; // 그 외에는 블럭 그룹을 반환
	}

	public static Block bfs(int x, int y) {
    // 블럭 그룹 지정용 bfs
		Queue<Pair> queue = new LinkedList<>();

		int color = map[x][y];
    // 시작 블럭의 색

		visit[x][y] = true;
		queue.offer(new Pair(x, y));
    // 방문 처리 및 큐에 초기 좌표 넣기
		int sum = 1;
		int rainbow = 0;
    // 시작 블럭은 1개, 무지개 블럭은 0개

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int cx = pair.x;
			int cy = pair.y;

			for (int i = 0; i < 4; i++) {
        // 4방향 bfs
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (checkRange(nx, ny)) {
					continue;
				}	// 맵 바깥이면 패스

				if (map[nx][ny] == -1) {
					continue;
				} // 검은색 블럭 패스

				if (map[nx][ny] == -99) {
					continue;
				} // 빈칸 패스

				if (visit[nx][ny]) {
					continue;
				} // 이미 방문한 곳 패스

				if (map[nx][ny] != color) { // 색은 다르지만
					if (map[nx][ny] == 0) { // 무지개라면 체크
						rainbow++; // 무지개 개수 증가
						sum++; // 총 개수 증가
						queue.offer(new Pair(nx, ny));
						visit[nx][ny] = true;
            // 방문 처리 및 좌표 추가
					}
					continue; // 다음으로 넘어가기
          // 밑에 내용 안하기 위함
				}

				sum++;
				queue.offer(new Pair(nx, ny));
				visit[nx][ny] = true;
        // 색이 같을 때 체크용
        // 개수 증가, 방문 처리 및 좌표 추가
			}

		}

		if(sum < 2){ 
      // 조건에 따라 블럭의 개수가 2개 이상일 때만 그룹
			return null;
		} else { // 2개 이상이므로 해당 그룹 반환
			return new Block(x, y, color, sum, rainbow);
		} 
	}

	public static void removeBlock(Block cur) {
    // 블럭 삭제
    // 원리는 bfs와 같음
    // 블럭 그룹에서 기준 블럭 이용하기
		Queue<Pair> queue = new LinkedList<>();
		visit = new boolean[n][n];
		visit[cur.x][cur.y] = true;
		map[cur.x][cur.y] = -99;
    // 시작 좌표 빈칸 만들기
		queue.offer(new Pair(cur.x, cur.y));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int cx = pair.x;
			int cy = pair.y;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (checkRange(nx, ny)) {
					continue;
				}

				if (map[nx][ny] == -1) {
					continue;
				}

				if (map[nx][ny] == -99) {
					continue;
				}

				if (visit[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != cur.color) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = -99;
						queue.offer(new Pair(nx, ny));
						visit[nx][ny] = true;
					}
					continue;
				}
				map[nx][ny] = -99;
				queue.offer(new Pair(nx, ny));
				visit[nx][ny] = true;

			}

		}
	}
	
	public static void gravity() {
    // 중력
		for(int i = 0; i < n; i++) {
			for(int j = n - 2; j >= 0; j--) {
        // 행은 밑에서부터 하기 
				if(map[j][i] == -1) continue;
				if(map[j][i] == -99) continue;
				// 검은색 블럭과 빈칸은 패스
				move(j, i);
        // 이번 블럭 옮기기
			}
		}
	}
	
	public static void move(int x, int y) {
    // 옮겨진 최종 좌표를 구하기
		int cx = x;
		// 행만 봐도 괜찮음
		while(true) { // 못 옮길 때까지 
			cx++; // 옮겨보기
			
			if(cx >= n) break;
      // 맵 바깥임 -> 못함
			
			if(map[cx][y] == -1) break;
      // 검은색 블럭이 있음 -> 못함
			
			if(map[cx][y] != -99) break;
      // 뭔가 다른 블럭이 있음 -> 못함
		}
		cx--; // 일단 증가시킨 것이 있으므로 
    // 감소시켜야 최종 좌표

		if (cx == x) {
			return;
		} // 움직이지 않음

		map[cx][y] = map[x][y];
		map[x][y] = -99;
    // 최종 좌표로 옮기고
    // 원래 좌표는 빈칸
	}
	
	static void rotate() {
    // 회전
    // 회전 결과를 복사본에 저장
    // 그리고 다시 맵으로 복사
    
		int[][] copy = new int[n][n];
    
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[j][n - i - 1];
			}
		} // 회전 결과를 복사본에 저장

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = copy[i][j];
			}
		}
	} // 결과물을 다시 맵으로

	public static void rainbowInitial() {
    // 무지개 방문 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					visit[i][j] = false;
				}
			}
		}
	} 

	public static boolean checkRange(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	} // 범위 체크

	public static class Block {
    // 블럭 그룹 클래스
		int x;
		int y;
		int color;
		int sum;
		int rainbow;
    // 좌표, 색, 블럭 개수, 무지개 블럭 개수

		public Block(int x, int y, int color, int sum, int rainbow) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
			this.sum = sum;
			this.rainbow = rainbow;
		}

		public boolean compares(Block o) {
      // 가장 큰 블록 그룹 탐색용
      // 블럭, 무지개, 행, 열 순서
      // 호출한 객체와 매개변수를 비교
      // 매개변수 쪽이 더 크면 true를 반환
      /* 
      if (max.compares(cur)) {
					max = cur;
				}
       매개변수 쪽이 더 크다면
       최대가 갱신되도록 해두었음
       블럭 수만 반영되는 것이 아니기에
       클래스 내에서 비교를 하게 해두었음
      */ 
			if (this.sum != o.sum) {
				return this.sum < o.sum;
			} 

			if (this.rainbow != o.rainbow)
				return this.rainbow < o.rainbow;

			if (this.x != o.x)
				return this.x < o.x;

			return this.y < o.y;
		}

	}

	public static class Pair {
    // 좌표 클래스
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
