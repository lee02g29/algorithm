import java.io.*;
import java.util.*;

public class Solved {
    // 과정 : 다리 놓을 수 있는 위치 다 찾고 저장하기
    // 크루스칼로 다리 놓기
    
	static int n, m;
	static int cnt;
	
	static int[][] visit;
	static int[][] map;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
    // 네 방향 탐색 

	static ArrayList<Pair> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		map = new int[n][m];
        // 지도
		visit = new int[n][m];
        // 방문 배열
		arr = new ArrayList<>();
        // 섬에 놓을 수 있는 섬 위치를 저장할 배열

		cnt = 2;
        // 섬에 번호를 붙이기 
        // = 유니온용 대표 번호가 될 것
		
		int sum = 0;


		for (int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} // 맵 입력받기

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					dfs(i, j, cnt++);
				}
			}
		} // 먼저 섬에 번호를 붙이기
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {

					
					for (int d = 0; d < 4; d++) {
						dfs(i, j, d, map[i][j]);
					}
				}
			}
		} // 한 방향으로만 dfs를 돌면서 다리를 놓을 수 있는 위치 찾기
		
		Collections.sort(arr);
        // 다리의 길이가 짧은 순서대로 정렬하기
        // 중복되더라도 유니온을 했다면 실행안됨 
		
		visit = new int[n][m];
		
		for(int i = 0; i < arr.size(); i++) {
			int x1 = arr.get(i).x1;
			int y1 = arr.get(i).y1;
			
			int x2 = arr.get(i).x2;
			int y2 = arr.get(i).y2;
			// from x1, y1 -> x2, y2
			int len = arr.get(i).len;
            // 다리 길이
			if(map[x1][y1] == map[x2][y2]) continue;
			// 둘이 이미 합쳐졌으면 안함
			union(x1, y1, x2, y2);
			// 섬 합치기
			sum += len;
            // 놓여진 다리의 길이 합
		}
		
		HashSet<Integer> set = new HashSet<>();
		// 섬이 다 합쳐졌다면 지도에는 대표 번호 하나와 0만이 있을 것
        // 중복제거용

		for (int l = 0; l < n; l++) {
			for (int k = 0; k < m; k++) {
				set.add(map[l][k]);
                // 지도에 있는 숫자 저장
			}
		}

		if(sum == 0 || set.size() > 2) bw.write(-1 + "\n"); 
        // 다리가 아예 없거나, 있어도 모든 섬을 하나로 할 수 없다면 -1
		else bw.write(sum + "\n");
        // 그 외엔 다리 길이 출력하기

		bw.flush();
		bw.close();

	}

	public static void dfs(int x, int y, int type) {
        // 섬 번호 붙이는 dfs
		visit[x][y] = 1; // 방문 처리
		map[x][y] = type; // 섬에 붙일 번호
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			
			if (check(nx, ny)) // 배열 바깥 처리
				continue;

			if (map[nx][ny] == 0) // 바다 안감
				continue;
			if (visit[nx][ny] == 1) // 이미 간 곳 안감
				continue;
			
			dfs(nx, ny, type); // 다음 방문
		}

	}

	public static void dfs(int x, int y, int d, int type) {
        // 다리 놓을 곳 탐색용 dfs
		int nx = x;
		int ny = y;
        // 이번 위치는?
		int cnt = 0;
		// 다리의 길이
		boolean check = false;
        // 다리를 놓을 수 있는가? 일단 아님

		while (true) {
			nx += dx[d];
			ny += dy[d];
			// 해당 방향으로 나아가기
			if (check(nx, ny))
				break;

			if(map[nx][ny] == type) break;
            // 같은 섬이면 그 방향으로 안감
			
			if (map[nx][ny] > 0 && map[x][y] != map[nx][ny]){
				// 가는 방향이 섬인데, 같은 섬이면
				check = true; // 다리 놓을 수 있다고 판단함
				break; // 더 이상 탐색 안함
			}

			visit[nx][ny] = 2; 
            // 방문 처리하긴 했는데 사용은 안했음
            // 문제 조건상 방문 했어도 가야할 일이 있기 때문
			if(map[nx][ny] == 0) cnt++;
            // 지나간 곳이 바다일 때만 다리길이 증가
		}
		
		
		if (check && cnt > 1) { 
            // 다리를 놓을 수 있고, 다리 길이가 1보다 클때만 놓기
			arr.add(new Pair(x, y, nx, ny, cnt));
            // from -> to, cnt길이를 가진 다리
		}
	}

	public static int find(int x, int y) { // 파인드
		return map[x][y]; // 걍 섬의 번호를 보내주기
	}
	
	public static void union(int x1, int y1, int x2, int y2) { // 유니온
		if(find(x1, y1) == find(x2, y2)) return; // 이미 합쳐졌으면 안함
		else { // 섬이 다르면?
			
			int change = map[x2][y2];
			int to = map[x1][y1];
			// from -> to

			for (int l = 0; l < n; l++) {
				for (int k = 0; k < m; k++) {
					if(map[l][k] == change) {
                        // from와 같은 섬 번호를 가졌다면
						map[l][k] = to;
                        // 모두 바꿔주기
					}
				}
			}

		}
	}


	public static boolean check(int x, int y) { // 지도 바깥 체크
		return x < 0 || x >= n || y < 0 || y >= m;
	}

	public static class Pair implements Comparable<Pair> {
        // 다리 정보용 클래스
		int x1;
		int y1;

		int x2;
		int y2;

		int len;

		Pair(int x1, int y1, int x2, int y2, int len) {
			this.x1 = x1;
			this.y1 = y1;

			this.x2 = x2;
			this.y2 = y2;

			this.len = len;
		}

		@Override
		public int compareTo(Pair o) { // 길이를 오름차순으로 정렬하기
			return this.len - o.len;
		}
	}

}
