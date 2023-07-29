import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = null;

		while ((str = bf.readLine()) != null) { // eof까지 입력받기
			int wid = Integer.parseInt(str) * 10000000; // 입력받는 것은 센티, 계산은 나노미터로
			int num = Integer.parseInt(bf.readLine()); // 개수
			boolean ans = false; // 플래그

			int[] nums = new int[num];

			for (int i = 0; i < num; i++) {
				nums[i] = Integer.parseInt(bf.readLine()); // 레고 크기들
			}

			Arrays.sort(nums); // 정렬

			int p1 = 0; 
			int p2 = num - 1;
      // 투포인터

			while (p1 < p2) {
				int sum = nums[p1] + nums[p2];
				
				if(sum == wid){ // 합과 구멍 너비가 같다면
					ans = true;
					break; 
				} else if(sum > wid) { // 더 크다면
					p2--; // 오른쪽 포인터 인덱스 감소
				} else { // 더 작다면
					p1++; // 왼쪽 포인터 증가 인덱스
				}
			}

			if (ans) // 답을 찾았다면 = 레고로 막을 수 있다면
				System.out.printf("yes %d %d\n", nums[p1], nums[p2]); 
        // 아무튼 버퍼는 못써서 써봄
			else
				System.out.printf("danger\n");
		}

		bw.flush();
		bw.close();
	}

}
