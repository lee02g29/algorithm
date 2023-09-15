import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		boolean[] alpha = new boolean[26];
		
		for(int i = 0; i < n; i++) {
			String[] str = bf.readLine().split(" "); // 문자열을 단어 단위로 분리
			int position_x = 0;
			int position_y = 0;
      // 단축키로 지정될 위치
			boolean check = false;
      // 단축키를 지정했는가?
			
			for(int j = 0; j < str.length; j++) {
				int first = Character.toLowerCase(str[j].charAt(0)) - 'a';
        // 각 단어별 맨 앞글자 체크
				
				if(!check && !alpha[first]) { 
          // 지정된 적 없으며, 해당 글자가 단축키가 아니라면
					position_x = j;
					position_y = 0;
          // 위치 설정
					check = true;
					alpha[first] = true;
          // break; // 있어도 되고 없어도 되고
          // 단축키 설정 완료, 해당 알파벳 사용처리
				}
			}
			
			if(!check) { // 앞 글자로는 단축키 지정이 안됐을 때
			outer: for(int j = 0; j < str.length; j++) // 왼쪽 단어부터 체크
					for(int k = 1; k < str[j].length(); k++) { 
            // 앞 글자는 위에서 봤으므로 그 다음부터
						
						int next = Character.toLowerCase(str[j].charAt(k)) - 'a';
            // 확인할 글자
						
						if(!alpha[next]) { // 이번 글자가 단축키가 아님
							alpha[next] = true;
							position_x = j;
							position_y = k;
							check = true;
							break outer;
							// 설정하고 과정 자체를 종료
						}
					}
				}

      // 출력과정
			for(int j = 0; j < str.length; j++) {
				for(int k = 0; k < str[j].length(); k++) {
					if(check && j == position_x && k == position_y) {
						bw.write("[" + str[j].charAt(k) + "]");
					} // 단축키 지정됐음 -> 이후 좌표가 같음 -> [] 출력
            // 최초 값으로 0 0으로 두어서 이리 했음
            // -1 -1으로 준다면 check 확인 필요 없음
            // 다만 시간 늘어나는 거 확인함
					else bw.write(str[j].charAt(k) + "");
          // 좌표지정된 단어 이외에는 그냥 출력
				}
				bw.write(" "); // 단어 분리과정에서 공백을 지웠으므로 출력
			}
			bw.write("\n");
			
		}		

		bw.flush();
		bw.close();
	}

}
