import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] pair = {0, 6, 4, 5, 2, 3, 1}; // 1과 6, 2와 4, 3과 5는 서로 마주봄
		
		int cnt = Integer.parseInt(bf.readLine());
		int[][] nums = new int[cnt][7]; // 1~6을 편하게 접근하려고
		int[][] max = new int[cnt][6]; // 최대값
		
		int sum = 0; // 이번 밑면에서의 최대값의 합
		int find = 0; // 이번 주사위에서 최대값
		int maxs = 0; // 총 최대값
		
		for(int i = 0; i < cnt; i++) { // 주사위 n개
			String[] str = bf.readLine().split(" ");
			
			for(int j = 0; j < 6; j++) { // 입력받기
				nums[i][j + 1] = Integer.parseInt(str[j]); 
			}				
		}
		
		int bottom = 0; // 밑면
		int top = 0; // 윗면
		
		for(int i = 1; i <= 6; i++) { 
			// 이거 3으로 두면 틀림 주의
			// i번째를 밑면으로 골랐음
			bottom = nums[0][i]; // 밑면의 숫자	
			top = nums[0][pair[i]]; // 윗면의 숫자
			sum = 0;
			
			for(int j = 0; j < cnt; j++) { // 주사위 탐색
				find = 0;

				for(int k = 1; k <= 6; k++) { // 주사위별 눈 탐색
					if(nums[j][k] == top) { // 주사위의 눈이 윗면이라면
						bottom = top; // 다음 주사위는 그 윗면을 밑면으로 두어야함 
						top = nums[j][pair[k]]; // 다음 위면은 밑면의 반대쪽
						
						find = finds(bottom, top, nums[j]); 
						// 윗면, 밑면을 제외한 최대값 찾기
						break; // 더 탐색하면 갱신된 값으로 찾으므로 종료할 것
					}
				}
				sum += find; // 최대값끼리 더하기
				if(sum > maxs) maxs = sum; // 총 최대값 갱신	
			}
			
			if(sum > maxs) maxs = sum; // 총 최대값 갱신		
		}

		bw.write(maxs + "\n"); // 출력

		bw.flush();
		bw.close();
	}
	
	public static int finds(int bottom, int top, int[] arr) {
		int max = -1;
		
		for(int i = 1; i <= 6; i++) {
			if(arr[i] == top || arr[i] == bottom) continue; 
			// 윗면 밑면은 포함 안 함
			if(arr[i] > max) max = arr[i];
			// 최대값 찾기
		}
		
		return max;
	}

}
