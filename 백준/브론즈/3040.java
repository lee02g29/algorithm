import java.util.*;
import java.io.*;

class Main {

	static int[] nums;
	static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		nums = new int[10]; // 난쟁이들이 가지고 있는 숫자
		order = new int[7]; // 고른 숫자들의 목록

		for (int i = 1; i <= 9; i++) { // 숫자 입력받기
			int num = Integer.parseInt(bf.readLine());
			nums[i] = num;
		}

		find(0, 0, 1); // 함수 호출, 하나도 안고름, 합이 0임, 첫번째 난쟁이부터

	}

	public static void find(int cnt, int sum, int start) { 
		// 조합
		
		if(cnt == 7) { // 7명을 골랐다면
			if(sum > 100) // 합이 100을 넘었다면 패스하기
				return;
			
			if(sum == 100) { // 합이 100이라면
				for(int i = 0; i < 7; i++) { // 출력하기
					System.out.println(order[i]);
				}
				return;
			}
			return;
		}
		
		for(int i = start; i <= 9; i++) { 
			// 난쟁이들 순서
			order[cnt] = nums[i];
					
			find(cnt + 1, sum + nums[i], i + 1);
			// 다음 난쟁이 탐색
		}
	}

}
