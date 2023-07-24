import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() ); // 문장 개수
		
		for(int i = 0; i < n; i++) {
			Stack<Character> left = new Stack<>(); // 커서 왼쪽 문자 스택
			Stack<Character> right = new Stack<>(); // 커서 오른쪽 문자 스택
			
			String str = bf.readLine();
			StringBuilder ans = new StringBuilder(); // 답을 저장할 스트링 빌더
			
			for(int j = 0; j < str.length(); j++) { // 각 문자별 접근
				char ch = str.charAt(j);
				
				if(ch == '<') { // 왼쪽 시프트
					if(!left.isEmpty()) right.push( left.pop() ); // 왼쪽에 있는 문자를 빼서 오른쪽으로
				}
				else if(ch == '>') { // 오른쪽 시프트
					if(!right.isEmpty()) left.push( right.pop() ); // 오른쪽에 있는 문자를 빼서 왼쪽으로
				}
				else if(ch == '-') { // 커서 왼쪽 문자 제거
					if(!left.isEmpty()) left.pop(); // 왼쪽 스택에서 문자 제거
				} else {
					left.push(ch); // 그 외에는 왼쪽에 문자 넣기
				}
				
			}
			
			while(!right.isEmpty()) {
				left.push( right.pop() );
			} // 오른쪽에 남은 문자 옮기기
			
			for(int l = 0; l < left.size(); l++) {
				ans.append(left.elementAt(l)); // 왼쪽 스택에 있는 문자, 스택 아래부터 출력
			} // 여기 ans += 쓰면 시간초과남 주의
      // 스트링빌더 추천
			
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
