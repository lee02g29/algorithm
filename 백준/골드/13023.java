import java.io.*;
import java.util.*;

public class Solved {

	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visit;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]); // n명의 사람
		int m = Integer.parseInt(str[1]); // m개의 관계

		check = false; // 가능한가?

		arr = new ArrayList<>();
		visit = new boolean[n]; // 방문 배열
		
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
		} // 2차 배열 만들기

		for (int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");

			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			arr.get(a).add(b);
			arr.get(b).add(a);

		} // 그래프 만들기 - 친구관계 만들기

		for(int i = 0; i < n; i++) {
			if(check) break; // 이미 확인됐으면 체크 안하기
			dfs(i, 1); // i번째 사람부터 시작하기, 깊이는 1
			
			visit = new boolean[n]; // 방문 초기화하기
		}		

		if (check) // 가능하면
			bw.write(1 + "\n"); // 1 출력
		else // 아니면
			bw.write(0 + "\n"); // 0 출력

		bw.flush();
		bw.close();

	}

	public static void dfs(int x, int sum) {
		visit[x] = true; // 방문처리
		
		if (sum > 4) { 
      // 4개 이상으로 방문할 수 있다면, 문제의 조건 달성
			check = true; // 가능하다고 처리하기
			return;
		}

		for (int i = 0; i < arr.get(x).size(); i++) {
			int temp = arr.get(x).get(i); // 연결된 사람들 확인하기

			if(visit[temp]) continue; // 이미 방문했다면 넘기기

			dfs(temp, sum + 1); // 다음 사람 확인하기
			
			visit[temp] = false; // 방문 반환하기 - 백트래킹
		}

	}
	
}
