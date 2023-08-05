import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		int s = Integer.parseInt(str[0]); // 문자열의 길이
		int p = Integer.parseInt(str[1]); // 부분 문자열의 길이
		
		String dna = bf.readLine(); // dna 문자열
		
		str = bf.readLine().split(" ");
		int[] cnt = new int[4]; 
    // 포함되야 할 문자들의 최소 개수, A C G T순
		int[] window = new int[4];
    // 현재보고 있는 부분 문자열의 문자 포함 개수
		int ans = 0;
		boolean check = true;
		
		for(int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(str[i]);
		}
		
		for(int i = 0; i < p; i++) { // 처음 부분 문자열 처리
			if(dna.charAt(i) == 'A') {
				window[0]++;
			} else if(dna.charAt(i) == 'C') {
				window[1]++;
			} else if(dna.charAt(i) == 'G') {
				window[2]++;
			} else if(dna.charAt(i) == 'T') {
				window[3]++;
			}
		} // 문자열의 문자들 탐색 후 개수 체크
		
		for(int j = 0; j < 4; j++) { 
      // 최소 개수보다 현재 개수가 더 적다면
			if(window[j] < cnt[j]) {
				check = false; // 부분 문자열은 사용할 수 없음
			}
		}
		
		if(check) ans++;
		
		for(int i = 1; i <= s  - p; i++) { 
      // 부분 문자열의 시작점
      // 시작점 + 부분 문자열의 길이는 문자열의 길이를 넘을 수 없음
			check = true;
			
			if(dna.charAt(i - 1) == 'A') {
				window[0]--;
			} else if(dna.charAt(i - 1) == 'C') {
				window[1]--;
			} else if(dna.charAt(i - 1) == 'G') {
				window[2]--;
			} else if(dna.charAt(i - 1) == 'T') {
				window[3]--;
			} // 윈도우에서 빠진 문자 처리
			
			if(dna.charAt(i + p - 1) == 'A') {
				window[0]++;
			} else if(dna.charAt(i + p - 1) == 'C') {
				window[1]++;
			} else if(dna.charAt(i + p - 1) == 'G') {
				window[2]++;
			} else if(dna.charAt(i + p - 1) == 'T') {
				window[3]++;
			} // 윈도우에 새로 들어온 문자 처리
			
			for(int j = 0; j < 4; j++) {
         // 최소 개수보다 현재 개수가 더 적다면
				if(window[j] < cnt[j]) {
					check = false; // 부분 문자열은 사용할 수 없음
				}
			}
			
			if(check) ans++; // 사용할 수 있는 문자열이면 개수 증가

		}
		
		bw.write(ans + "\n"); // 개수 출력
		
		bw.flush();
		bw.close();

	}

}
