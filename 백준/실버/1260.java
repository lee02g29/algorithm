import java.util.*;
import java.io.*;

class Main {

	static int n, m;
	static ArrayList<ArrayList<Integer>> arr;
	static Queue<Integer> queue;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		n = Integer.parseInt(str[0]); // 정점 개수
		m = Integer.parseInt(str[1]); // 간선 개수
		int v = Integer.parseInt(str[2]); // 탐색 시작지점
		
		arr = new ArrayList<>(); // 그래프
		visit = new boolean[n + 1]; // 방문 여부
		queue = new LinkedList<>(); // dfs용 큐
		
		for(int i = 0; i <= n; i++) {
			arr.add(new ArrayList<Integer>()); // 2중 arraylist 쓰ㄱ
		}
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");
			
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			
			arr.get(s).add(e);
			arr.get(e).add(s);
      // 양방향 그래프임
		} // 그래프 입력
		
		for(int i = 0; i <= n; i++) {
			Collections.sort(arr.get(i));
		} // 여러 간선이 있다면 작은 숫자를 먼저 방문하도록 정렬
		
		visit[v] = true;
		dfs(v);
    // dfs 시작, v 방문 처리
		
		System.out.println();
    // bfs 출력 구분용
		
		visit = new boolean[n + 1];
		// 방문 여부 초기화
    
		queue.offer(v);

		visit[v] = true;
		bfs(v);
    // bfs 시작, 큐에 v를 넣고 방문 처리
    
		bw.flush();
		bw.close();

	}
	
	public static void dfs(int n) {
		System.out.print(n + " "); // 방문 정점 출력
		
		for(int i = 0; i < arr.get(n).size(); i++) { 
      // 이번 정점에 연결된 정점들을 탐색하기
			if(!visit[arr.get(n).get(i)]) { 
        // 연결된 정점을 방문한 적 없으면 
				
				visit[arr.get(n).get(i)] = true; // 방문처리
				
				dfs(arr.get(n).get(i)); // 다음 좌표 탐색
			}
		}
		
	}
	
	public static void bfs(int n) {

		while(!queue.isEmpty()) {
			
			int next = queue.poll();
			// 이번 정점
			System.out.print(next + " ");
			// 방문 정점 출력
			for(int i = 0; i < arr.get(next).size(); i++) {
        // 이번 정점에 연결된 정점들 탐색
				if(!visit[arr.get(next).get(i)]) { 
          // 연결된 정점을 방문한 적 없으면
					queue.offer(arr.get(next).get(i));
          // 큐에 넣어 탐색 준비하기
					visit[arr.get(next).get(i)] = true;
          // 방문 처리하기
				}
			}			
      
		}
		
	}
}
