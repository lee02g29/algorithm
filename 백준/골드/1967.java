import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Pair>> arr;
	static boolean[] visit;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() );
		arr = new ArrayList<>();

		visit = new boolean[n + 1];

		ans = Integer.MIN_VALUE;

		for (int i = 0; i <= n; i++) {
			ArrayList<Pair> node = new ArrayList<>();

			arr.add(node);
		} // 2차 arrayList

		for (int i = 0; i < n - 1; i++) {
			String[] str = bf.readLine().split(" ");

			int p = Integer.parseInt(str[0]); // 부모노드
			int s = Integer.parseInt(str[1]); // 자식노드
			int l = Integer.parseInt(str[2]); // 가중치

			arr.get(p).add(new Pair(s, l));
			arr.get(s).add(new Pair(p, l));
      // 양방향 그래프와 같이 때문에 둘 다 저장
		}

		for (int i = 1; i <= n; i++) {
      // 1번 노드부터 dfs로 길이를 체크
			if (visit[i] == true)
				continue;

			dfs(i, 0);
		}
		
		bw.write(ans + "\n"); // 최장 거리 출력

		bw.flush();
		bw.close();
	}

	public static void dfs(int cur, int sum) {		
		// dfs
    
		for (int i = 0; i < arr.get(cur).size(); i++) {
			int temp = arr.get(cur).get(i).x;
      // 다음 노드

			if (visit[temp] == true)
				continue;
			
			visit[cur] = true;
			dfs(arr.get(cur).get(i).x, sum + arr.get(cur).get(i).l);
      // 다음 노드, 지금까지의 거리로 dfs 
			
			visit[cur] = false;
		}
		
		if(ans < sum) ans = sum;
    // 거리 갱신
	}
	
	public static class Pair implements Comparable<Pair> { 
    // 도착점과 가중치만 저장할 클래스
		int x;
		int l;
		
		Pair(int x, int l) {
			this.x = x;
			this.l = l;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.l == o.l) {
				return this.x - o.x;
			}
			return this.l - o.l;
		}
	}
}
