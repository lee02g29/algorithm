import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Pair> queue = new PriorityQueue<>(); // 우선순위 큐
    // 작은 숫자들이 먼저 나옴
		
		int n = Integer.parseInt( bf.readLine() );
		
		for(int i = 0; i < n; i++) {
			int nums = Integer.parseInt( bf.readLine() ); // 이번 숫자
			
			if(nums == 0) { // 0이라면 값을 출력해야함
				if(queue.isEmpty()) bw.write(0 + "\n"); // 큐가 비었다면 0출력
				else { // 아니라면
					Pair p = queue.poll(); // 큐 앞에서 숫자를 가져온다
					if(p.plus == 0) bw.write(p.x * -1 + "\n"); // 음수였던 숫자라면 -1을 해주기
					else bw.write(p.x + "\n"); // 아니라면 그냥 숫자 출력하기
				}
			} else {
				if(nums < 0) queue.add(new Pair(nums * -1, 0));
          // 음수라면 양수로 변환하고, Pair에 음수였음을 저장하기
				else queue.add(new Pair(nums, 1)); // 그 외엔 그냥 저장하기
			}

		}
		
		bw.flush();
		bw.close();
	}
	
	public static class Pair implements Comparable<Pair>{
		int x; // 값(양수만)
		int plus; // 음수 여부, 0이면 음수, 1이면 양수
		
		Pair(int x, int plus) {
			this.x = x;
			this.plus = plus;
		}

		@Override
		public int compareTo(Pair o) { // 정렬
			if(this.x == o.x) return this.plus - o.plus;
      // 같은 숫자라면 음수가 먼저 나오도록
			else return this.x - o.x;
		}
	}

}
