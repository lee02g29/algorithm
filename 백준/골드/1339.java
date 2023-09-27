import java.util.*;
import java.io.*;

class Main {
	public static int[] par;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() );
    // 단어 개수
		
		ArrayList<String> arr = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			arr.add( bf.readLine() ); // 단어 저장하기
		}
		
		Integer[] alpha = new Integer[26];
    // 각 알파벳 별 계수 저장용
		
		for(int i = 0; i < 26; i++) {
			alpha[i] = 0;
      // Integer배열은 초기값이 null이라 초기화 해야함
 		}
		
		for(int i = 0; i < n; i++) {
			String str = arr.get(i);
			int temp = (int)Math.pow(10, str.length() - 1);
      // 10 ^ 문자열 길이 => 계수만들기 용도
			
			for(int j = 0; j < str.length(); j++) {
        // 문자의 각 알파벳 탐색
				alpha[str.charAt(j) - 'A'] += temp;
        // 알파벳에 현재 계수 더해주기
				temp = temp / 10;
        // 뒤로 갈수록 자리수가 작아짐
			}
		}
		
		Arrays.sort(alpha, Collections.reverseOrder());
		// 계수 내림차순 정렬
		
		int ans = 0; // 답
		int nums = 9;
    // 9부터 배분하기
		
		for(int i = 0; i < 9; i++) {
			ans += alpha[i] * nums--;
      // 계수가 높은 순서대로 큰 숫자 배분
      // 계수 * 숫자
		}
		
		bw.write(ans + "\n");
		// 답 출력
		
		bw.flush();
		bw.close();
	}

}
