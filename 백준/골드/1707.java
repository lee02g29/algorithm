import java.util.*;
import java.io.*;

class Main {
	
	static ArrayList<ArrayList<Integer>> arr;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt( bf.readLine() );
		
		for(int t = 0; t < test; t++) {
			String[] str = bf.readLine().split(" ");
			
			int v = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
      // 정점의 개수와 간선의 개수
			
			arr = new ArrayList<>();
      // 그래프
			nums = new int[v + 1];
      // 각 정점에 번호를 붙일 것
			boolean check = false;
      // 이분 그래프인지
			
			for(int i = 0; i <= v; i++) {
				arr.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < e; i++) {
				str = bf.readLine().split(" ");
				
				int start = Integer.parseInt(str[0]);
				int end = Integer.parseInt(str[1]);
				
				arr.get(start).add(end);
				arr.get(end).add(start);
			} // 그래프 만들기
      // 무향그래프임
			
			for(int i = 1; i <= v; i++) {
				if(nums[i] == 0) { // 0이면 번호를 안붙인 것이므로
					check = bfs(i, 1); // bfs를 통해 인접 정점 확인하기
				}
				if(!check) break; // 이분 그래프가 아니면 탐색 그만하기
			}
			
			if(check) { // 이분그래프
				bw.write("YES" + "\n");
			} else { // 이분그래프가 아님
				bw.write("NO" + "\n");
			}
		}

		bw.flush();
		bw.close();
	}

	public static boolean bfs(int x, int num) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(x);
		nums[x] = num;
    // 시작 정점 큐에 넣기
    // 그리고 번호 붙여주기
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i = 0; i < arr.get(cur).size(); i++) {
				int next = arr.get(cur).get(i);
        // 이번 정점과 연결된 정점
				if(nums[cur] == nums[next]) return false;
				// 두 정점의 번호가 같다면 이분 그래프가 아님
        
				if(nums[next] == 0) { // 번호가 아직 안붙었으면
					queue.offer(next);
					nums[next] = nums[cur] * -1;
				} // 큐에 넣고 이번 정점과는 다른 번호 붙이기

			}
		}
		
		return true;
    // 위에서 false 반환이 없었고 반복이 끝났으면
    // 이분 그래프임
	}

}
