import java.io.*;
import java.util.*;

public class Main {

	public static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String all = bf.readLine(); // 탐색 대상 문자열

		String str = bf.readLine(); // 찾고자 하는 문자열

		pi = new int[str.length()]; 
    // 일치하지 않을 때, 이동할 곳 인덱스 저장 배열

		kmp(str);
    // kmp 알고리즘

		int ans = 0;
		int j = 0;

		ArrayList<Integer> idx = new ArrayList<>();
    // 문자열이 등장하는 인덱스를 저장할 리스트
    
    // kmp와 같음
		for (int i = 0; i < all.length(); i++) {
			while (j > 0 && all.charAt(i) != str.charAt(j)) {
				
				j = pi[j - 1];
			}

			if (all.charAt(i) == str.charAt(j)) { // 차이점은 이곳
				if (j == str.length() - 1) { 
          // 같으면서도 패턴 문자열의 끝까지 다다랐음
          // = 패턴 문자열이 포함되었음
					ans++; // 답 추가
					idx.add(i - j + 1);
          // 원하는 답은 문자열의 최초 인덱스이므로
          // 현재 인덱스 - 길이 + 1
					j = pi[j];
          // 그렇지만 더 있을 수 있으므로 탐색을 멈추지 말것
				} else {
					j++; // 문자열의 끝이 아니면 접두값 증가
				}

			}
		}
		
		bw.write(ans + "\n"); // 답 개수 출력
		
		for(int i = 0; i < idx.size(); i++) {
			bw.write(idx.get(i) + " ");
		} // 인덱스 값 출력
		
		bw.write("\n");
		
		bw.flush();
		bw.close();

	}

	public static void kmp(String str) {

		int j = 0; // 접두
    // i : 접미
		for (int i = 1; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = pi[j - 1];
			} // 다르면 pi[접두값 - 1] 배열 값을 접두값으로 사용 
      // 다를 수록 0에 가까워짐
      // 다르면 맨 앞부터 보게 됨
      // j가 0이 되거나 같을 때 까지 반복함

			if (str.charAt(i) == str.charAt(j)) {
				pi[i] = ++j;
			} // 두 문자가 같다면 j 값을 증가시키고 
      // pi배열에 저장
		}
	}

}
