import java.io.*;
import java.util.*;

public class Main {
	public static int size;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int[][] map;
	public static int[][] roopy;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int problem = 1;
		
		while(true) { // 정확한 테스트 케이스의 개수는 없음
			size = Integer.parseInt(bf.readLine());
			if(size == 0) break; // 0이 입력되면 종료
			
			map = new int[size][size]; // 맵
			roopy = new int[size][size]; // 최소 감소 루피
			visit = new boolean[size][size]; // 방문여부
			
			for(int i = 0; i < size; i++) {
				String[] str = bf.readLine().split(" ");
				
				for(int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					roopy[i][j] = Integer.MAX_VALUE;
				}
			} // 맵 입력받기 & 루피 초기화
			
			find(); // 탐색 시작

			bw.write("Problem " + problem + ": " + roopy[size - 1][size - 1] + "\n");
			problem++;
		}
		
		bw.flush();
		bw.close();

	}
	
	public static void find() {	
		visit[0][0] = true;
		
		PriorityQueue<Pair> queue = new PriorityQueue<>();
    // 우선순위큐, 루피수가 작은 곳으로 감
		
		queue.offer(new Pair(0, 0, map[0][0]));
    // 0, 0부터 시작하기
		
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();				
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				// 사방 탐색 
				if(check(nx, ny)) {
					continue;
				}
				
				if(visit[nx][ny]) continue;
        // 맵 바깥이거나 방문한적 있으면 패스
				
				if(roopy[nx][ny] > map[nx][ny] + cur.roopy) {
          // 현재 저장된 값이 새로운 값보다 크면 갱신
					roopy[nx][ny] = map[nx][ny] + cur.roopy;
					visit[nx][ny] = true;
					
					queue.offer(new Pair(nx, ny, roopy[nx][ny]));
          // 큐에 넣기
				}
			}
		}
	}
	
	public static boolean check(int x, int y) {
		return x < 0 || x >= size || y < 0 || y >= size;
	}
	
	public static class Pair implements Comparable<Pair> {
    // 좌표 & 루피수 클래스
		int x;
		int y;
		int roopy;
		
		public Pair(int x, int y, int roopy) {
			this.x = x;
			this.y = y;
			this.roopy = roopy;
		}

		@Override
		public int compareTo(Pair o) {
			return this.roopy - o.roopy;
		}	// 루피수로 정렬함
		
	}

}
