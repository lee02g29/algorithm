import java.io.*;
import java.util.*;

public class Solved {

	static int[] mem;
	static boolean[] visit;
	static boolean[] check;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(bf.readLine());

		for (int t = 0; t < test; t++) {
			int n = Integer.parseInt(bf.readLine());

			mem = new int[n + 1];
			visit = new boolean[n + 1];
			check = new boolean[n + 1];
			sum = 0;

			String[] str = bf.readLine().split(" ");

			for (int i = 1; i <= n; i++) { // 원하는 매칭 입력받기
				int temp = Integer.parseInt(str[i - 1]);
				mem[i] = temp;
				
				if (i == temp) { // 혼자 조를 하기를 원한다면
					check[i] = true;
					sum++;
				} // 미리 처리하기
			}

			for (int i = 1; i <= n; i++) {
				if (check[i]) // 이미 조 편성이 완료됐다면
					continue; // 넘기기
				dfs(i); // i번째 사람부터 dfs-사이클 찾기 시작
			}

			bw.write((n - sum) + "\n");
      // sum은 팀 매칭 인원이기 때문에
      // 총 인원에서 빼야, 매칭 안된 인원임
		}

		bw.flush();
		bw.close();

	}

	public static void dfs(int n) {
		if(check[n]) return; // 이미 완성됐다면 반환

		if(visit[n]){ 
      // 확인이 안끝났는데 이미 방문한 점을 만났다
      // = 사이클이다
      // = 팀원 매칭을 할 수 있다
			sum++; // 매칭 인원 증가
			check[n] = true; // 팀 완성
		}
		
		visit[n] = true; // 방문처리
		dfs(mem[n]); // 다음 점(사람) 탐색하기
		
		check[n] = true; // 사이클이 아니더라도 탐색 완료했으므로, 처리하기
		
		visit[n] = false; // 방문 처리 반환
		
	}

}
