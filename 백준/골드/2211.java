import java.util.*;

import javax.swing.plaf.metal.MetalTheme;

import java.io.*;

class Main {
	
	static ArrayList<ArrayList<Pair>> com;
	static boolean[] visit;
	static int[] dist;
	static ArrayList<Pair> path;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
    // 컴퓨터 개수, m개의 회선
    
		visit = new boolean[n + 1];
		dist = new int[n + 1];
    // 컴퓨터 방문 여부
    // 최단 거리
		
		int len = 0;
		
		com = new ArrayList<>();
		path = new ArrayList<>();
    // 컴퓨터 그래프
    // 복구된 네트워크
		
		for(int i = 0; i <= n; i++) {
			com.add(new ArrayList<Pair>());
			dist[i] = Integer.MAX_VALUE;
		} // 컴퓨터 그래프용 자료구조 생성 
    // 최단거리, 큰 값으로 초기화
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");
			
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int dis = Integer.parseInt(str[2]);
			
			com.get(s).add(new Pair(s, e, dis));
			com.get(e).add(new Pair(e, s, dis));
		} // 컴퓨터 그래프 만들기
    // 양방향임
    // 복구된 그래프 저장을 위해
    // 시작지점과 도착지점을 모두 객체로 저장함
		
		bfs(1); // 1번 컴퓨터부터 시작
		
		bw.write(path.size() + "\n");
    // 복구된 그래프 회선 개수
		
		for(int i = 0; i < path.size(); i++) {
			Pair cur = path.get(i);
			bw.write(cur.s + " " + cur.e + "\n");
		} // 복구된 그래프 출력

		bw.flush();
		bw.close();
	}
	
	public static void bfs(int n) {
		PriorityQueue<Pair> queue = new PriorityQueue<>();
    // 우선순위 큐를 이용하여 통신 시간 작은 순으로 바로 구하기
		
		queue.offer(new Pair(n, n, 0));
    // 시작 지점부터 큐에 넣기
		dist[n] = 0; // 시작 지점의 코스트 0
		visit[n] = true; // 시작 지점 방문 처리
		
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
      // 큐에서 다음 지점 꺼내기
			
			if(!visit[cur.e]) {
				visit[cur.e] = true;
				path.add(cur);
			} // 방문하지 않았다면
      // 방문 처리하고
      // 복구 회선에 추가
			
			for(int i = 0; i < com.get(cur.e).size(); i++) {
				Pair next = com.get(cur.e).get(i);
        // cur 지점과 연결된 컴퓨터들 탐색
				
				if(dist[next.e] > dist[cur.e] + next.dis) {
					dist[next.e] = dist[cur.e] + next.dis;
					queue.offer(new Pair(next.s, next.e, dist[next.e]));
					// 도착지점의 코스트 > 시작지점의 코스트 + 새로운 코스트
          // 더 짧으므로 갱신하고 복구 회선에 이번 지점 추가
				}
					
			}
		}
	}

  // 그래프
	public static class Pair implements Comparable<Pair>{
		int s;
		int e;
		int dis;
		// 시작, 종료, 코스트
		public Pair(int s, int e, int dis) {
			super();
			
			this.s = s;
			this.e = e;
			this.dis = dis;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dis - o.dis;
      // 코스트 오른차순으로 정렬
		}

	}

}
