import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int d = Integer.parseInt(str[1]);
		int[] dp = new int[d + 1]; // i거리까지 최단 거리

		ArrayList<shortCut> arr = new ArrayList<>();

		for (int i = 0; i <= d; i++) {
			dp[i] = i;
		} // 초기항은 지름길을 타지 않고 가는 것

		for (int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");

			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int dist = Integer.parseInt(str[2]);

			if (s > e) // 역주행
				continue;
			if (e - s > d) // 지름길이 아닌 경우
				continue;
			if (e > d || s < 0) // 거리 바깥인 경우
				continue;
      // 전부 포함 안함
			arr.add(new shortCut(s, e, dist));
      // 그 외에는 지름길 등록
		} // 지름길 등록

		for (int i = 1; i <= d; i++) { // 도착지점까지 거리 탐색

			for (int j = 0; j < arr.size(); j++) { // 지름길 탐색
				shortCut cut = arr.get(j); // 이번 탐색 지름길

				if (i == cut.e) { // 현재 거리 = 지름길의 도착점 => 지름길
					int dis = dp[cut.s] + cut.dist; 
          // 운전 거리 = 시작 지점에서 운전한 거리 + 지름길의 거리
					dp[i] = Math.min(dp[i], Math.min(dp[i - 1] + 1, dis));
          // 이전 지점에서 + 1을 한 거리와 운전 거리를 1차 비교하여 작은 것 선택
          // 이미 저장된 값과 위에서 비교한 값 중 작은 것 선택하여 갱신
				} else { // 지름길이 아님
					dp[i] = Math.min(dp[i], dp[i - 1] + 1);
          // 이미 저장된 값과 이전 거리 + 1한 값 비교하여 최소값으로 갱산
				}
			}
		}

		bw.write(dp[d] + "\n");
    // 마지막 지점의 거리 출력
		bw.flush();
		bw.close();
	}

	public static class shortCut {
    // 지름길 클래스
		int s;
		int e;
		int dist;

		public shortCut(int s, int e, int dist) {
			super();
			this.s = s;
			this.e = e;
			this.dist = dist;
		}

	}
}
