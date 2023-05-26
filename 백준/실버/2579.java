import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		int[] temp = new int[n]; // 계단별 점수
		int[] score = new int[n + 3]; // 계단 별 점수 뒤집기 -> 마지막 계단을 반드시 밟아야 하기 때문에 첫번째로 바꾸기
		int[][] max = new int[n + 3][3]; // 현재 계단까지의 최대값 [계단인덱스][연속횟수], 연속 횟수 0 = 해당 계단 넘어감

		for (int i = 0; i < n; i++) {
			temp[i] = Integer.parseInt(bf.readLine());
			score[n - i - 1] = temp[i]; // 점수를 입력받는 동시에 뒤집기
		}
		
		max[0][1] = score[0]; // 첫번째 계단은 반드시 지나감
		max[1][2] = score[0] + score[1]; 
    // 첫번째 계단을 반드시 밟아야함에 따라, 2번 연속 계단을 지나가게 됨 = [1][1]은 따로 하지 않아도 괜찮음

		
		for(int i = 2; i < n; i++) { // 두번째 항부터 DP
			max[i][0] = Math.max(max[i-1][1], max[i-1][2]); // 해당 계단을 지나가지 않을 때, 바로 전 계단에서의 최고점을 저장하기
			max[i][1] = Math.max(max[i-2][1], max[i-2][2]) + score[i]; 
      // 해당 계단이 연속 횟수로 1일 때, 앞의 계단을 밟지 않았기 때문에 2번째 전 계단에서 최고점을 찾고, 거기에 이번 계단의 점수를 더하기
      // 생각해볼 점 : 바로 전 계단의 0번 째 인덱스를 사용하는 것도 가능할까?
			max[i][2] = max[i-1][1] + score[i];
      // 해당 계단이 연속 횟수로 2일 때, 앞의 계단을 밟았고 3번 연속 밟는 것은 불가능하기 때문에, 이전 계단의 점수 중 연속횟수가 1인 경우를 가져오기
      // 이후 해당 계단의 점수 더하기
		}

		bw.write(Math.max(Math.max(max[n - 1][1], max[n - 1][2]),max[n - 1][0]) + "\n");
		// 마지막 계단의 점수 중 최대값을 출력하기 
    // 마지막 계단을 밟지 않아도 최대가 될 수 있음을 주의하기
		bw.flush();
		bw.close();

	}

}
