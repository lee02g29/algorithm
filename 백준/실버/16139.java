import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = bf.readLine(); // 주어진 문자열
		
		int t = Integer.parseInt( bf.readLine() ); // 질문수
		
		int[][] nums = new int[26][str.length() + 1]; 
    		// n번째에 등장한 문자 기록용
		int[][] prefix = new int[26][str.length() + 1]; 
    		// n번째까지 각 문자가 몇 번 나타났는지 누적함
		
		for(int i = 1; i <= str.length(); i++) {
			nums[str.charAt(i - 1) - 'a'][i]++; 
      			// [등장 문자 인덱스][지금 인덱스]
      			// a를 0으로 z를 25로
		}
		
		for(int i = 0; i < 26; i++) {
			for(int j = 1; j <= str.length(); j++) {
				prefix[i][j] = prefix[i][j - 1] + nums[i][j];
        			// 알파벳별 누적합 구하기
			}
		}
		
		for(int i = 0; i < t; i++) {
			String[] q = bf.readLine().split(" ");
			
			char s = q[0].charAt(0); // 찾으려는 문자
			int start = Integer.parseInt(q[1]) + 1; 
      			// 시작 지점 prefix는 1부터 시작이기에, 입력받은 값에 + 1하기
			int end = Integer.parseInt(q[2]) + 1; 
      			// 종료 지점
		
			bw.write(prefix[s - 'a'][end] - prefix[s - 'a'][start-1] + "\n");
      			// 시작 지점도 값을 포함하므로, 그 앞에 값을 빼기
		}

		bw.flush();
		bw.close();
	}

}
