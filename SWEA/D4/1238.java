import java.io.*;
import java.util.*;

public class Solved {

	static int[] visit;
	static Queue<Integer> queue;
	static ArrayList< ArrayList<Integer>> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t = 1; t <= 10; t++) {
			String[] str = bf.readLine().split(" ");
			
			int n = Integer.parseInt( str[0] );
			int s = Integer.parseInt( str[1] );
			
			int max = -1; // 최대값은 -1으로 기본세팅
			int last = 0; // 마지막 숫자
			
			visit = new int[101]; // 방문 값 + 깊이
			queue = new LinkedList<>(); // 큐
			
			arr = new ArrayList<>(); // 인접리스트
			
			for(int i = 0; i <= 100; i++) {
				arr.add(new ArrayList<>());
			} // 2차 리스트만들기
			
			str = bf.readLine().split(" ");
			int index = 0;
			
			for(int i = 0; i < n / 2; i++) {
				int a = Integer.parseInt( str[index++] );
				int b = Integer.parseInt( str[index++] );
				
				if(!arr.get(a).contains(b)) arr.get(a).add(b);
			} // 관계 입력받기
			
			for(int i = 0; i <= 100; i++) {
				Collections.sort(arr.get(i));
			} // 걍 정렬해봤음

			visit[s] = 1; // 최초 시작점
			queue.add(s); // 시작점부터 bfs
			
			bfs(s);
			
			for(int i = 1; i <= 100; i++) {
				if(visit[i] > 0 && visit[i] > max) max = visit[i];
			} // 방문한적 있고, 깊이가 최대인 것을 찾기
			
			for(int i = 1; i <= 100; i++) {
				if(visit[i] == max) last = i;
			} // 깊이가 최대인 곳 중 숫자 큰거 찾기
			
			bw.write("#" + t + " " + last + "\n");
			
		}

		bw.flush();
		bw.close();

	}


	public static void bfs(int x) {
		
		while(!queue.isEmpty()) {
			int next = queue.poll();

			for(int i = 0; i < arr.get(next).size(); i++) {
				int temp = arr.get(next).get(i); // 연결된 사람 찾기

				if(visit[temp] != 0) continue; // 방문한적 있으면 패스
				
				queue.offer(temp); // 큐에 넣기
				
				visit[temp] = visit[next] + 1; // 깊이 + 1

			}
		}

	}

}
