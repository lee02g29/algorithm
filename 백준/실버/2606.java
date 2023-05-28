import java.util.*;
import java.io.*;

class Main {
	static ArrayList<ArrayList<Integer>> arr;
	static int cnt;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine()); // 컴퓨터 개수
		int link = Integer.parseInt(bf.readLine()); // 연결쌍의 개수
		
		arr = new ArrayList<>(); // 그래프를 저장할 자료형
		cnt = 0; // 감염 컴퓨터 개수
		visit = new boolean[n + 1]; // 방문 여부
		
		for(int i = 0; i <= n; i++) { // 2차원 arrayList 만들기
			ArrayList<Integer> node = new ArrayList<>();
			
			arr.add(node);
		}
		
		for(int i = 0; i < link; i++) { // 컴퓨터 연결 상태 저장하기
			String[] str = bf.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			arr.get(a).add(b);
			arr.get(b).add(a);
      // 양방향 그래프 모양이므로, 둘 다 저장
		}
		
		visit[1] = true; // 1번 컴퓨터는 이미 방문함(시작 점이기 때문)
		dfs(1); // 1번 컴퓨터부터 시작하기
		
		bw.write(cnt + "\n");
		
		bw.flush();
		bw.close();

	}
	
	public static void dfs(int cur) { // dfs, 매개변수는 현재 방문 중인 컴퓨터의 번호
		
		for(int i = 0; i < arr.get(cur).size(); i++) { // 현재 컴퓨터와 연결된 그래프를 탐색
			if(!visit[ arr.get(cur).get(i) ]) { // 연결된 컴퓨터를 방문한 적이 없다면
				visit[ arr.get(cur).get(i) ] = true; // 방문 처리 하기
				cnt++; // 감염 컴퓨터 수 증가시키기
				dfs(arr.get(cur).get(i)); // 연결된 컴퓨터로 넘어가기
				
			}			
		}
	}

}
