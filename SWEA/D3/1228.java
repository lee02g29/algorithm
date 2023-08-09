import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1; i <= 10 ; i++) {
			int n = Integer.parseInt( bf.readLine() ); // 문자열의 길이
			ArrayList<String> arr = new ArrayList<>();
			
			String[] temp = bf.readLine().split(" "); // 원본 문자열
			
			int pro = Integer.parseInt( bf.readLine() ); // 명령어의 개수
			
			String tmp = bf.readLine(); // 명령어 목록
			
			StringTokenizer st = new StringTokenizer(tmp); // 명령어 분리용 토크나이저
			
			for(int k = 0; k < pro; k++) {
				st.nextToken(); // i 코드 스킵
				
				int start = Integer.parseInt( st.nextToken() ); // 시작지점
				int next = Integer.parseInt( st.nextToken() ); // 입력 숫자 개수
				
				for(int j = 0; j < n; j++) {
					arr.add(temp[j]); // 원본 문자열
				}
				
				
				for(int j = 0 ; j < next; j++) {
					arr.add( start + j, st.nextToken() ); 
          // start번째 위치에 숫자들 추가
				}
			}	
			
			for(int x = 0; x < 10; x++) {
				bw.write(arr.get(x)+ " " ); // 출력
			}
		}
		
		bw.flush();
		bw.close();

	}

}
