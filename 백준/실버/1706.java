import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		// 크기
		String[][] map = new String[r][c];
    // 크로스워드

		for(int i = 0; i < r; i++) {
			str = bf.readLine().split("");
			
			for(int j = 0; j < c; j++) {
				map[i][j] = str[j];
			}
		} // 크로스워드 입력
		
		String min = String.valueOf((char)('z' + 1));
    // 최초의 비교대상 문자, 알파벳인 z보다 크도록.
				
		for(int i = 0; i < r; i++) {	// 가로
			StringBuilder temp = new StringBuilder(); 
      // 스트링빌더 안쓰면 답으로 숫자가 나와버린다...
			for(int j = 0; j <= c; j++) {
				if(j == c || map[i][j].equals("#")) { 
          // 끝에 도달했거나, 검은 칸에 도달했으면
          // 단어 체크를 시작하기
					String voca = temp.toString(); // 이번 세로줄의 단어
					if(voca.length() >= 2 && min.compareTo(voca) > 0) {
            // 길이가 2이고, 이미 저장된 답보다 사전순으로 앞선다면, 
						min = voca; // 갱신
					}
					temp = new StringBuilder(); 
          // 이번 탐색이 끝났으므로 스트링빌더 초기화
				} else {
					temp.append(map[i][j]); 
          // 아직 끝에 도달하지 못했음 = 이번 단어를 임시로 더하기
				}
			}
		}
		
		for(int j = 0; j < c; j++) { // 세로, 과정은 위와 동일
			StringBuilder temp = new StringBuilder();
			for(int i = 0; i <= r; i++) {
				if(i == r || map[i][j].equals("#")) {
					String voca = temp.toString();
					if(voca.length() >= 2 && min.compareTo(voca) > 0) {
						min = voca;
					}
					temp = new StringBuilder();
				} else {
					temp.append(map[i][j]);
				}
			}
		}
		
		bw.write(min + "\n"); // 답 출력

		bw.flush();
		bw.close();
	}


}
