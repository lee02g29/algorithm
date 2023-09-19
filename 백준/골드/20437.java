import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt( bf.readLine() ); // 게임 수
		
		for(int t = 0; t < test; t++) { 
			String str = bf.readLine();
			int k = Integer.parseInt( bf.readLine() ); // 조건 : k개를 포함
			
			int min = Integer.MAX_VALUE; // 짧은 연속 문자열의 길이
			int max = -1; // 긴 연속 문자열의 길이
			
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
      // 각 알파벳마다 등장한 인덱스 저장용
			
			for(int i = 0; i < 26; i++) {
				arr.add(new ArrayList<>());
			}
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				arr.get(ch - 'a').add(i);
			} // 문자열 문자마다 등장한 인덱스 저장하기
			
			for(int i = 0; i < 26; i++) { // 각 알파벳 별 탐색
				if(arr.get(i).size() >= k) { // 각 알파벳이 등장한 횟수가 k번 이상일 때만 체크
					for(int j = 0; j < arr.get(i).size() - (k - 1); j++) {
            // 탐색 시작 지점, 간격이 k-1이어야하므로, 범위는 횟수에서 (k-1) 뺀 곳 까지
						min = Math.min( min, arr.get(i).get(k - 1 + j) - arr.get(i).get(j) + 1 );
            // 알파벳이 등장한 두 지점 사이의 길이를 체크. 더 짧은 것을 사용
						max = Math.max( max, arr.get(i).get(k - 1 + j) - arr.get(i).get(j) + 1 );
            // 알파벳이 등장한 두 지점 사이의 길이를 체크. 더 긴 것을 사용
            // 어같은 알파벳 사이의 길이만 체크해서,첫번째와 마지막 글자가 같은 경우는 체크 안해도 ok
					}
				}
			}
			
			if(min != Integer.MAX_VALUE && max != -1) { // 값이 변했다면
				bw.write(min + " " + max + "\n"); // 출력
			} else { // 아니면 -1
				bw.write(-1 + "\n");
			}
		}

		bw.flush();
		bw.close();
	}

}
