import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]); // n개의 보석
		int k = Integer.parseInt(str[1]); // k개의 주머니
		long ans = 0; // 총 훔칠 수 있는 가격, 개당 가격 * k가 상당히 크다

		ArrayList<Jewel> list = new ArrayList<>(); // 보석을 저장할 리스트
		PriorityQueue<Integer> bag = new PriorityQueue<>(Collections.reverseOrder());
    // 현재 가방의 최대 무게보다 작은 보석들을 담을 우선순위 큐, 후보 목록, 내림차순
		int[] weight = new int[k];
    // 가방들의 최대무게

		for (int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");

			int m = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);

			list.add(new Jewel(m, v));
		} // 보석 정보 등록

		for (int i = 0; i < k; i++) {
			weight[i] = Integer.parseInt(bf.readLine());
		} // 가방 무게 등록

		Collections.sort(list);
		Arrays.sort(weight);
    // 둘 다 정렬함
    // 보석의 정렬 = 무게는 오름차순, 가치는 내림차순
    // 가방 무게의 정렬 오름차순
    // 어느 가방에 보석이 들어갈 수 있다는 것은
    // 그 이후의 가방에도 그 보석은 들어갈 수 있다는 것을 의미
    // 이 점을 이용하여 풀기

		int j = 0;

		for (int i = 0; i < k; i++) { // 가방 탐색
			while (true) {
				if (j >= n) // 
					break;
				Jewel next = list.get(j); // 이번 보석 정보

				if (weight[i] < next.m) 
          // 가방의 무게 < 이번 보석의 무게라면 더 볼 필요가 없음
					break;

				bag.offer(next.v); 
        // 가방의 무게 >= 보석의 무게이므로, 후보 목록에 넣기
        // 가격만을 넣기. 위에 써놓은 내용에 따라 무게는 넣지 않아도 괜찮음
				j++; // 가방 카운트 증가
			}

			if (!bag.isEmpty()) {
				ans += bag.poll();
			} // 우선순위큐 정렬에 따라, 가장 앞에 있는 값은 가격이 가장 큰 보석이므로
      // 더해주기

		}

		bw.write(ans + "\n");

		bw.flush();
		bw.close();
	}

	public static class Jewel implements Comparable<Jewel> {
    // 보석 클래스
		int m;
		int v;

		Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			if (this.m == o.m) {
				return o.v - this.v; // 가격은 내림차순
			} else
				return this.m - o.m; // 무게는 오름차순

		}
	}

}
