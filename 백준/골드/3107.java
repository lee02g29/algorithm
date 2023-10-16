import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = bf.readLine();
		
		if(str.contains("::")) {
			str = str.replace("::",":zeros:");
		} // 0으로만 이루어져서 압축된 그룹 1차 복원
		
		String[] split = str.split(":");
    // :로 분리
		
		ArrayList<String> input = new ArrayList<>();
		ArrayList<String> ans = new ArrayList<>();
    // :로 분리된 ip주소 구성요소
    // 공백과 4보다 짧은 길이인 것 처리 이후 구성요소
		
		for(int i = 0; i < split.length; i++) {
			input.add(split[i]);
		}
		
		for(int i = 0; i < input.size(); i++) {
			String next = input.get(i);
      // 이번 구성요소
			
			if(next.isEmpty()) continue;
      // 맨 앞이 :: 이었다면 분리할 때 공백이 있었음
      // 공백은 0000으로 바꿀 것

			while(next.length() < 4) {
				next = "0" + next;
			} // 0을 생략해서 4보다 짧아진 요소들
      // 앞에 0붙여주기
			
			ans.add(next);
      // 처리 목록에 저장
		}
		
		
		String[] ip = new String[8];
		int zero = 8 - ans.size() + 1;
    // 공백이거나 생략되었어서 0000으로 바꾸어야할 개수
		int idx = 0;
		
		for(int i = 0; i < ans.size(); i++) { 
      // 요소들 처리하기
			if(ans.get(i).equals("zeros")) {
        // 생략된 0그룹
				while(zero-- > 0) {
					ip[idx] = "0000";
					idx++;
				} // 개수만큼 0000추가
			} else {
				ip[idx] = ans.get(i);
				idx++;
			} // 그 외엔 그대로 더해주기
		}
		
		for(int i = 0; i < 7; i++) {
			bw.write(ip[i] + ":");
		} 
		bw.write(ip[7] + "\n");
    // ip 주소 처럼 출력하기
    
		bw.flush();
		bw.close();
	}


}
