import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]); // 집 n개
		int k = Integer.parseInt(str[1]); // 공유기 k개
		
		int[] nums = new int[n]; // 집 좌표
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(bf.readLine());
		} // 집 좌표 저장
		
		Arrays.sort(nums);
    // 이분탐색을 위한 오름차순 정렬
		
		int left = 1;
		int right = nums[n-1] - nums[0];
    // 이분 탐색 왼쪽 끝, 오른쪽 끝
    // 집 간격 사이를 토대로 이분탐색
    
		int ans = 0;
		// 최대거리
		while(left <= right) {
			int mid = (left + right) / 2; // 중갑 값
			int prev = nums[0]; // 이전 집
			int cnt = 1; // mid 값을 기준으로 설치했을 때 개수
			
			for(int i = 1; i < n; i++) {
				if(nums[i] - prev >= mid) {
          // 현재 집과 이전에 저장된 집 사이의 간격이 mid보다 크면
					cnt++; // 개수 증가
					prev = nums[i]; // 저장된 집 교체
				}
			} // 집 간격 별로 체크
      // mid보다 작으면 공유기 설치 안한다는 뜻
			
			if(cnt >= k) { 
        // 이번에 설치된 공유기의 개수가 주어진 것보다 많으면
				ans = Math.max(ans, mid); 
        // 이전에 저장된 값과 현재의 거리 비교 후 큰 값 저장
				left = mid + 1;
        // 간격 늘려보기
			}
			else right = mid - 1;
      // 그 외엔 간격 줄여보기
			
		}
		
		bw.write(ans + "\n"); // 출력
		
		bw.flush();
		bw.close();
	}

}
