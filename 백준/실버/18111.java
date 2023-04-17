import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]); // 세로
		int m = Integer.parseInt(str[1]); // 가로
		int b = Integer.parseInt(str[2]); // 이미 가지고 있는 블럭수

		int min = 256; // 최대 높이
		int max = 0; // 최저 높이 
		int minus = 0; // 제거할 블럭수
		int plus = 0; // 쌓아야할 블럭수
		int sum = 0; // 총 시간

		int ans = 2 * 64 * 1000000; // 모든 블럭을 빼는 것을 가정으로 하여서 최대 값을 정함 -> 99999999정도로도 돌아가는 것으로 추정
		int height = 0; // 최대 높이

		Integer[][] map = new Integer[n][m];

		for (int i = 0; i < n; i++) { // 값 입력받기
			str = bf.readLine().split(" ");
			for (int j = 0; j < m; j++) { 
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] > max) // 최대값찾기
					max = map[i][j];
				if (map[i][j] < min) // 최소값찾기
					min = map[i][j];
			}
		}

		for (int c = min; c <= max; c++) { // 최소 높이부터 최대 높이까지만 탐색
			minus = 0;
			plus = 0;
			sum = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int temp = map[i][j] - c; // 현재 높이(c값)와 탐색중인 좌표의 높이 차
					
					if (temp > 0) { // 높이차가 0보다 크다면, 블럭을 제거해야함
						minus += temp; // 제거한 블럭수
					} else if (temp < 0) { // 높이차가 0보다 작다면, 블럭을 추가해야함
						plus -= temp; // 추가한 블럭수
					}
				}
			}
			
			if (b + minus >= plus) { // 원래있던 블럭수 + 제거된 블럭수(맵에서 제거되면서 늘어남) >= 추가해야할 블럭수 
                               // 블럭을 모두 같은 높이로 쌓을 수 있음 -> 시간 측정 // 추가해야할 블럭수가 더 많다면 같은 높이가 될 수 없음
				sum += 2 * minus + plus; // 제거하는 시간 2초, 쌓는 시간 1초 
				
				if (ans >= sum) { // 시간이 더 짧다면 갱신, 낮은 높이부터 찾기 때문에 항상 더 높은 높이로 저장됨
					ans = sum;
					height = c;
				}
				
			}
		}

		bw.write(ans + " " + height + "\n"); // 출력
        
        	bw.flush();
        	bw.close();

	}
}
