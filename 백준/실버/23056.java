import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
    // m개의 학급 n명까지 받기
		
		ArrayList<student> odd = new ArrayList<>();
		ArrayList<student> even = new ArrayList<>();
		int[] cnt = new int[m + 1];
    // 홀수용 인원 저장용
    // 짝수용 인원 저장용
    // 각 학급별 인원 현황 배열

		while(true) {
			str = bf.readLine().split(" ");
			
			if(Integer.parseInt(str[0]) == 0) break;
      // 0 0이면 입력 종료
			
			int nums = Integer.parseInt(str[0]);
			String name = str[1];
      // 학급 숫자와 이름
			
			if(nums % 2 == 1) {
				if(cnt[nums] < n) { 
          // 학급 선착순이 마감이 안됐다면
					odd.add(new student(nums, name));
					cnt[nums]++;
          // 인원 등록하고, 학급 인원 현황 증가
				} // 학급이 홀수인 경우
			} else {
				if(cnt[nums] < n) {
					even.add(new student(nums, name));
					cnt[nums]++;
				}
			} // 학급이 짝수인 경우
		}
		
		Collections.sort(odd);
		Collections.sort(even);
    // 둘 다 정렬하기
    
		for(int i = 0; i < odd.size(); i++) {
			bw.write(odd.get(i).nums + " " + odd.get(i).name + "\n");
		} // 홀수부터 출력하기
		
		for(int i = 0; i < even.size(); i++) {
			bw.write(even.get(i).nums + " " + even.get(i).name + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static class student implements Comparable<student>{
		int nums;
		String name;
		
		public student(int nums, String name) {
			this.nums = nums;
			this.name = name;
		}

		@Override
		public int compareTo(student other) {
			if(this.nums == other.nums) { // 같은 학급
				if(this.name.length() == other.name.length()) { // 글자가 같음
					return this.name.compareTo(other.name); // 사전순
				}
				else return this.name.length() - other.name.length();
        // 글자수가 다르면 글자수 짧은 순
			} else return this.nums - other.nums;
      // 그 외에는 학급 번호 순
		}

	}
}
