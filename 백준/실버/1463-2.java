import java.io.*;
import java.util.*;

public class Assignment {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		int n = Integer.parseInt( bf.readLine() );
		
		int[] nums = new int[n + 1];

		for(int i = 2; i <= n; i++) {
			nums[i] = nums[i - 1] + 1; // 1빼는 경우
			if(i % 2 == 0) nums[i] = Math.min(nums[i], nums[i / 2] + 1); 
      // 2로 나누는 경우, 기존의 값과 /2의 값 + 1 크기를 비교하기
			if(i % 3 == 0) nums[i] = Math.min(nums[i], nums[i / 3] + 1);
      // 3로 나누는 경우, 기존의 값과 /3의 값 + 1 크기를 비교하기
		}
		
		bw.write(nums[n] + "\n"); // 출력하기
		
		bw.flush();
		bw.close();
	}

}
