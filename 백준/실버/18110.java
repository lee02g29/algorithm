import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt( bf.readLine() ); //  의견의 개수
		ArrayList<Integer> arr = new ArrayList<>(); // 난이도 저장할 리스트
		int cut = (int)Math.round((double)num * 0.3 / 2); 
    // 절사평균 30%, 2로 나누어 한 쪽 절사 인원만 구하기
    // double로 캐스팅하여 소수점 처리 -> int로 캐스팅하기
    // 꼭 필요하진 않을지도.
		int score = 0; // 절사된 의견을 제외한 난이도의 합
		
		for(int i = 0; i < num; i++) {
			int diff = Integer.parseInt( bf.readLine() );
			
			arr.add(diff);
		} // 의견들 모두 저장하기
		
		Collections.sort(arr); // 정렬하기
    // Arrays.sort()보다 이쪽이 조금 더 빠른 것으로 추측
	
		for(int i = cut; i < num - cut; i++) { 
      // 절사되는 인원은 아예 탐색하지 않음
			score += arr.get(i); 
		}

		bw.write( Math.round( (double)score / (num - cut * 2) ) + "\n");
    // 총 스코어를 총 인원으로 나눔
    // 절사인원을 따로 빼는 것을 잊지 말 것.
    // double로 캐스팅을 해주어 나눗셈에서 차이가 발생하는 것 방지하기
		
		bw.flush();
		bw.close();

	}
}
