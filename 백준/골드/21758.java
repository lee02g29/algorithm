import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt( bf.readLine() );
		
		int[] nums = new int[n + 1]; // 숫자
		int[] prefix = new int[n + 1]; // 누적합
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
    // 경우 세 개의 최대 값
		int max = 0;
		// 총 최대 값
		String[] str = bf.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			nums[i + 1] = Integer.parseInt(str[i]);
		}
		// 숫자
    
		for(int i = 1; i <= n; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
		}
    // 누적합
		
		for(int i = 2; i < n; i++) { 
      // 벌통 - 꿀벌 - 꿀벌, 벌통이 왼쪽 끝에 있다면, 다른 벌은 오른쪽 끝에 있어야 최대값
      // 다른 벌 위치를 고르며 최대 값을 찾기
      // 다른 벌 위치의 숫자를 빼는 것을 잊지 말자 -> prefix 값 빼지 말자
			int temp = (prefix[n - 1] - prefix[0]) + (prefix[i - 1] - prefix[0]) - nums[i];
      
			if(temp > sum1) sum1 = temp;
		}
		
		for(int i = 2; i < n; i++) { // 
      // 꿀벌 - 꿀벌 - 벌통, 벌통이 오른쪽 끝에 있다면, 다른 벌은 왼쪽 끝에 있어야 최대값
      // 그 외엔 동일
			int temp = (prefix[n] - prefix[1]) + (prefix[n] - prefix[i]) - nums[i];
      
			if(temp > sum2) sum2 = temp;
		}

		for(int i = 2; i < n; i++) {
      // 꿀벌 - 벌통 - 꿀벌, 벌통이 가운데 어딘가에 있을 때. 꿀벌은 양쪽 끝에 있어야 최대값
      // 이곳에서는 숫자를 추가로 뺄 필요가 없다
			int temp = (prefix[i] - prefix[1]) + (prefix[n - 1] - prefix[i - 1]);
			
			if(temp > sum3) sum3 = temp;
		}
		
		max = max(sum1, sum2, sum3); // 세 값 중 최대 값 찾기
		
		bw.write(max + "\n"); // 출력

		bw.flush();
		bw.close();

	}
	
	public static int max(int a, int b, int c) {
		int temp = 0;
		
		if(a > b) temp = a;
		else temp = b;
		// a와 b중 큰거 찾기 
		if(temp > c) return temp;
		else return c;
    // 위에서 구한 큰거와 c를 비교하여 값 반환
	}

}
